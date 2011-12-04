package projekt.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.itcollege.team11.AdminAlluvus;
import ee.itcollege.team11.RiigiAdminYksus;
import ee.itcollege.team11.RiigiAdminYksuseLiik;
import ee.itcollege.team11.Vaeosa;
import ee.itcollege.team11.VoimalikAlluvus;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "riigiadminyksuseliiks", formBackingObject = RiigiAdminYksuseLiik.class)
@RequestMapping("/riigiadminyksuseliiks")
@Controller
public class RiigiAdminYksuseLiikController {

    @RequestMapping(value = "/{riigiAdminYksuseLikId}/{riigiAdminYksuseLikRemoveId}", params = "delete", method = RequestMethod.GET)
    public String remove(@PathVariable("riigiAdminYksuseLikId") Long riigiAdminYksuseLikId, @PathVariable("riigiAdminYksuseLikRemoveId") Long riigiAdminYksuseLikRemoveId, Model uiModel) {
    	RiigiAdminYksuseLiik.findRiigiAdminYksuseLiik(riigiAdminYksuseLikRemoveId).remove();
        uiModel.asMap().clear();
        return "redirect:/riigiadminyksuseliiks/" + riigiAdminYksuseLikId + "?form";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid RiigiAdminYksuseLiik riigiAdminYksuseLiik, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	if(riigiAdminYksuseLiik.getVoimalikAlluvuses2() != null) {
    		for(VoimalikAlluvus alluvus: riigiAdminYksuseLiik.getVoimalikAlluvuses2()) {
    			alluvus.setRiigiAdminYksuseLiik1(riigiAdminYksuseLiik);
    			alluvus.persist();
    		}
    	}
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("riigiAdminYksuseLiik", riigiAdminYksuseLiik);
            addDateTimeFormatPatterns(uiModel);
            return "riigiadminyksuseliiks/create";
        }
        uiModel.asMap().clear();
        riigiAdminYksuseLiik.persist();
        return "redirect:/riigiadminyksuseliiks/" + encodeUrlPathSegment(riigiAdminYksuseLiik.getRiigiAdminYksuseLikId().toString(), httpServletRequest);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid RiigiAdminYksuseLiik riigiAdminYksuseLiik, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	/**
    	 * Kontrollime, kas sisestatav alluvus erineb praeguses ja vajadusel tekitame uue ning sulgeme vana
    	 */
    	if(riigiAdminYksuseLiik.getVoimalikAlluvuses2() != null) {
    		for(VoimalikAlluvus alluvus: riigiAdminYksuseLiik.getVoimalikAlluvuses2()) {
    			alluvus.setRiigiAdminYksuseLiik1(riigiAdminYksuseLiik);
    			alluvus.persist();
    		}
    	}
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("riigiAdminYksuseLiik", riigiAdminYksuseLiik);
            addDateTimeFormatPatterns(uiModel);
            return "riigiadminyksuseliiks/update";
        }
        uiModel.asMap().clear();
        riigiAdminYksuseLiik.merge();
        return "redirect:/riigiadminyksuseliiks/" + encodeUrlPathSegment(riigiAdminYksuseLiik.getRiigiAdminYksuseLikId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{riigiAdminYksuseLikId}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("riigiAdminYksuseLikId") Long riigiAdminYksuseLikId, Model uiModel) {
        uiModel.addAttribute("riigiAdminYksuseLiik", RiigiAdminYksuseLiik.findRiigiAdminYksuseLiik(riigiAdminYksuseLikId));
        uiModel.addAttribute("saaballuda", findSaabAlluda(riigiAdminYksuseLikId));
        uiModel.addAttribute("alluvad", findChildrens(riigiAdminYksuseLikId));
        
        addDateTimeFormatPatterns(uiModel);
        return "riigiadminyksuseliiks/update";
    }

	private Collection<RiigiAdminYksuseLiik> findChildrens(Long riigiAdminYksuseLikId) {

		String query = "SELECT l2" +
				" FROM RiigiAdminYksuseLiik l" +
				" JOIN l.voimalikAlluvuses2 va" +
				" JOIN va.riigiAdminYksuseLiik1 l2" +
				" WHERE l.riigiAdminYksuseLikId = :liikId" +
					" AND (va.suletud > :date OR va.suletud IS NULL)" +
					" AND (l2.suletud > :date OR l2.suletud IS NULL)";
		return RiigiAdminYksuseLiik.entityManager().createQuery(query, RiigiAdminYksuseLiik.class).setParameter("liikId", riigiAdminYksuseLikId).setParameter("date", new Date()).getResultList();
	}

	private Collection<RiigiAdminYksuseLiik> findSaabAlluda(Long riigiAdminYksuseLikId) {
		Collection<RiigiAdminYksuseLiik> liigid = new ArrayList<RiigiAdminYksuseLiik>();
		String queryYlem = "SELECT l2" +
							" FROM RiigiAdminYksuseLiik l" +
							" JOIN l.voimalikAlluvuses1 va" +
							" JOIN va.riigiAdminYksuseLiik2 l2" +
							" WHERE l.riigiAdminYksuseLikId = :liikId" +
					       	" 	AND (va.suletud > :date OR va.suletud IS NULL)" +
					       	" 	AND (l2.suletud > :date OR l2.suletud IS NULL)";
		Collection<RiigiAdminYksuseLiik> liigid1 = RiigiAdminYksuseLiik.entityManager().createQuery(queryYlem, RiigiAdminYksuseLiik.class)
				.setParameter("liikId", riigiAdminYksuseLikId)
				.setParameter("date", new Date())
				.getResultList();
		

		String query = "SELECT l" +
						" FROM RiigiAdminYksuseLiik l" +
						" WHERE l.riigiAdminYksuseLikId != :liikId" +
						" 		AND (l.suletud > :date OR l.suletud IS NULL)";
						
		if(liigid1.size() > 0) {
			liigid.addAll(liigid1);
			query += "		AND l != (" + queryYlem + ")";
		}
		
		liigid.addAll(RiigiAdminYksuseLiik.entityManager().createQuery(query, RiigiAdminYksuseLiik.class)
				.setParameter("liikId", riigiAdminYksuseLikId)
				.setParameter("date", new Date())
				.getResultList());
		
		return liigid;
	}
}
