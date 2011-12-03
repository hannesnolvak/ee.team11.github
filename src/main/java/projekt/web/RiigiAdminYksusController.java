package projekt.web;

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

import ee.itcollege.team11.AdminAlluvus;
import ee.itcollege.team11.RiigiAdminYksus;

@RooWebScaffold(path = "riigiadminyksuses", formBackingObject = RiigiAdminYksus.class)
@RequestMapping("/riigiadminyksuses")
@Controller
public class RiigiAdminYksusController {

    @RequestMapping(params = "raport", method = RequestMethod.GET)
    public String raport(@PathVariable("kuupaev") Long kuupaev, Model uiModel) {
    	Date date = new Date(kuupaev);
    	uiModel.addAttribute("otsinguTulemus", findSearchResult((date == null ? date : null)));
    	
        addDateTimeFormatPatterns(uiModel);
        return "riigiadminyksuses/raport";
    }
    
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
    	AdminAlluvus a = AdminAlluvusController.getAdminYksusAlluvus(riigiAdminYksus.getRiigiAdminYksusId());
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

		String query = "SELECT y2" +
				" FROM RiigiAdminYksus o" +
				" JOIN o.adminAlluvuses1 a" +
				" JOIN a.riigiAdminYksus2 AS y" +
				" JOIN y.riigiAdminYksuseLiik yl" +
				" JOIN yl.riigiAdminYksuses y2" +
				" WHERE o.riigiAdminYksusId = :yksusId" +
					" AND (a.suletud > :date OR a.suletud IS NULL)";
		return RiigiAdminYksus.entityManager().createQuery(query, RiigiAdminYksus.class).setParameter("yksusId", riigiAdminYksusId).setParameter("date", new Date()).getResultList();
    }
    
    public Collection<RiigiAdminYksus> findChildrens(Long riigiAdminYksusId) {

		String query = "SELECT y" +
				" FROM RiigiAdminYksus o" +
				" JOIN o.adminAlluvuses2 a" +
				" JOIN a.riigiAdminYksus1 AS y" +
				" WHERE o.riigiAdminYksusId = :yksusId" +
					" AND (a.suletud > :date OR a.suletud IS NULL)";
		return RiigiAdminYksus.entityManager().createQuery(query, RiigiAdminYksus.class).setParameter("yksusId", riigiAdminYksusId).setParameter("date", new Date()).getResultList();
    }
}
