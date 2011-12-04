package projekt.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import antlr.ASdebug.ASDebugStream;

import ee.itcollege.team11.AdminAlluvus;
import ee.itcollege.team11.RiigiAdminYksus;

@RooWebScaffold(path = "riigiadminyksuses", formBackingObject = RiigiAdminYksus.class)
@RequestMapping("/riigiadminyksuses")
@Controller
public class RiigiAdminYksusController {
    
    public Collection<AdminAlluvus> findSearchResult(Date kuupaev) {
		String query = "SELECT a" +
				" FROM AdminAlluvus a" +
//				" JOIN a.riigiAdminYksus1 AS y" +
				" WHERE a.alates <= :date" +
					" AND (a.suletud IS NULL || a.suletud > :date)";
		//alates
		//suletud
		return AdminAlluvus.entityManager().createQuery(query, AdminAlluvus.class).setParameter("date", kuupaev).getResultList();
    }
    
    @RequestMapping(value = "/{riigiAdminYksusId}/{riigiAdminYksusRemoveId}", params = "delete", method = RequestMethod.GET)
    public String remove(@PathVariable("riigiAdminYksusId") Long riigiAdminYksusId, @PathVariable("riigiAdminYksusRemoveId") Long riigiAdminYksusRemoveId, Model uiModel) {
        RiigiAdminYksus.findRiigiAdminYksus(riigiAdminYksusRemoveId).remove();
        uiModel.asMap().clear();
        return "redirect:/riigiadminyksuses/" + riigiAdminYksusId + "?form";
    }
	
    @RequestMapping(value = "/{riigiAdminYksusId}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("riigiAdminYksusId") Long riigiAdminYksusId, Model uiModel) {
        uiModel.addAttribute("riigiAdminYksus", RiigiAdminYksus.findRiigiAdminYksus(riigiAdminYksusId));
        uiModel.addAttribute("saaballuda", findRiigiAdminYksuseVoimalikudAlluvad(riigiAdminYksusId));
        uiModel.addAttribute("alluvad", findChildrens(riigiAdminYksusId));
        
        addDateTimeFormatPatterns(uiModel);
        return "riigiadminyksuses/update";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid RiigiAdminYksus riigiAdminYksus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {

    	/**
    	 * Kontrollime, kas sisestatav alluvus erineb praeguses ja vajadusel tekitame uue ning sulgeme vana
    	 */
//    	AdminAlluvus a = AdminAlluvusController.getAdminYksusAlluvus(riigiAdminYksus.getRiigiAdminYksusId());
    	if(riigiAdminYksus.getAdminAlluvuses2() != null) {
    		for(AdminAlluvus alluvus: riigiAdminYksus.getAdminAlluvuses2()) {
    			alluvus.setRiigiAdminYksus1(riigiAdminYksus);
    			alluvus.persist();
    		}
    	}
    	
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("riigiAdminYksus", riigiAdminYksus);
            addDateTimeFormatPatterns(uiModel);
            return "riigiadminyksuses/update";
        }
        uiModel.asMap().clear();
        riigiAdminYksus.merge();
    	
        return "redirect:/riigiadminyksuses/" + encodeUrlPathSegment(riigiAdminYksus.getRiigiAdminYksusId().toString(), httpServletRequest);
    }
	
    public Collection<RiigiAdminYksus> findRiigiAdminYksuseVoimalikudAlluvad(Long riigiAdminYksusId) {
    	
    	Collection<RiigiAdminYksus> yksused = new ArrayList<RiigiAdminYksus>();

    	// hetkel aktiivne ylem
		String queryYlem = "SELECT y" +
							" FROM RiigiAdminYksus o" +
							" JOIN o.adminAlluvuses1 a" +
							" JOIN a.riigiAdminYksus2 AS y" +
							" WHERE o.riigiAdminYksusId = :yksusId" +
						       	" AND (a.suletud > :date OR a.suletud IS NULL)" +
						       	" AND (y.suletud > :date OR y.suletud IS NULL)";
		
		Collection<RiigiAdminYksus> yksused1 = RiigiAdminYksus.entityManager().createQuery(queryYlem, RiigiAdminYksus.class).setParameter("yksusId", riigiAdminYksusId).setParameter("date", new Date()).getResultList();
		
		// k6ik ylej22nud v6imalikud ylemad
		String query = "SELECT y" +
						" FROM RiigiAdminYksus o" +
						" JOIN o.riigiAdminYksuseLiik AS yl" +
						" JOIN yl.voimalikAlluvuses1 AS va" +
						" JOIN va.riigiAdminYksuseLiik2 AS yl1" +
						" JOIN yl1.riigiAdminYksuses AS y" +
						" WHERE o.riigiAdminYksusId = :yksusId" +
				       		" AND (va.suletud > :date OR va.suletud IS NULL)" +
				       		" AND (y.suletud > :date OR y.suletud IS NULL)";
		if(yksused1.size() > 0) {
			yksused.addAll(yksused1);
			query += " AND y != (" + queryYlem + ")";
		}

		yksused.addAll(RiigiAdminYksus.entityManager().createQuery(query, RiigiAdminYksus.class).setParameter("yksusId", riigiAdminYksusId).setParameter("date", new Date()).getResultList());
		
		return yksused;
    }
    
    public Collection<RiigiAdminYksus> findChildrens(Long riigiAdminYksusId) {

		String query = "SELECT y" +
						" FROM RiigiAdminYksus o" +
						" JOIN o.adminAlluvuses2 a" +
						" JOIN a.riigiAdminYksus1 AS y" +
						" WHERE o.riigiAdminYksusId = :yksusId" +
							" AND (a.suletud > :date OR a.suletud IS NULL)" +
							" AND (y.suletud > :date OR y.suletud IS NULL)";
		return RiigiAdminYksus.entityManager().createQuery(query, RiigiAdminYksus.class)
																		.setParameter("yksusId", riigiAdminYksusId)
																		.setParameter("date", new Date())
																		.getResultList();
    }
}
