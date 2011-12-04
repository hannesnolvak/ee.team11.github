package projekt.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.itcollege.team11.AdminAlluvus;
import ee.itcollege.team11.RiigiAdminYksus;
import ee.itcollege.team11.Vaeosa;
import ee.itcollege.team11.VaeosaAlluvus;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "vaeosas", formBackingObject = Vaeosa.class)
@RequestMapping("/vaeosas")
@Controller
public class VaeosaController {
	
	
    @RequestMapping(value = "/{vaeosaIdId}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("vaeosaIdId") Long vaeosaIdId, Model uiModel) {
        uiModel.addAttribute("vaeosa", Vaeosa.findVaeosa(vaeosaIdId));
        uiModel.addAttribute("alluvadVaeosad", Vaeosa.findAlluvadVaeosadByVaeosaID(vaeosaIdId));
        uiModel.addAttribute("saaballuda", findAllVaeosasButMe(vaeosaIdId));

        
        addDateTimeFormatPatterns(uiModel);
        
    	
        return "vaeosas/update";
    }
    
    
	@RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid Vaeosa vaeosa, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	/**
    	 * Kontrollime, kas sisestatav alluvus erineb praeguses ja vajadusel tekitame uue ning sulgeme vana
    	 */    	
    	if(vaeosa.getVaeosaAlluvuses2() != null) {    		
    		for(VaeosaAlluvus alluvus: vaeosa.getVaeosaAlluvuses2()) {
    			alluvus.setVaeosa1(vaeosa);
    			alluvus.persist();
    		}
    	}
    	
    	if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vaeosa", vaeosa);
            addDateTimeFormatPatterns(uiModel);
            return "vaeosas/update";
        }
        uiModel.asMap().clear();
        vaeosa.merge();
        return "redirect:/vaeosas/" + encodeUrlPathSegment(vaeosa.getVaeosaIdId().toString(), httpServletRequest);
    }
	   
    
    

    private Collection<Vaeosa> findAllVaeosasButMe(Long myId) {
    	Collection<Vaeosa> vaeosas = new ArrayList<Vaeosa>();
    	
    	// hetkel aktiivne ylem
    	Long bossId = (long) 0;
    	Vaeosa bossVaeosa = getBossVaeosaByVaeosaId(myId);
    	if (bossVaeosa != null){
    		vaeosas.add(bossVaeosa);
    		bossId = bossVaeosa.getVaeosaIdId();
    	}
		
		// Koik teised aktiivsed v2eosad
    	Collection<Vaeosa> otherVaeosas = getOtherVaeosasButMeAndBoss(myId, bossId);
    	if (otherVaeosas != null) {
    		vaeosas.addAll(otherVaeosas);
    	}

    	
    	return vaeosas;	
	}

    


	public Vaeosa getBossVaeosaByVaeosaId(Long myId)
    {
		/*
		 VaeosaAlluvus va = VaeosaAlluvusController.getVaeosaAlluvusYlemusSuheByVaeosaID(myId);
		 
		if (va != null){
			return va.getVaeosa2();
		}
		return null;
		
		*/
    	try {    	
			String queryYlem =  "SELECT boss " +
								"FROM   Vaeosa              AS me " +
								"JOIN   me.vaeosaAlluvuses1 AS meBoss " +
								"JOIN   meBoss.vaeosa2      AS boss " +
								"WHERE  me.vaeosaIdId = :myId " + 
							    "  AND  (meBoss.suletud > :date OR meBoss.suletud IS NULL)";
							    
			return Vaeosa.entityManager()
			             .createQuery(queryYlem, Vaeosa.class)
			             .setParameter("myId", myId)
			             .setParameter("date", new Date())
			             .getSingleResult();		
    	} catch (EmptyResultDataAccessException e)
    	{
    		return null;
    	}
    	
    }

	
    private Collection<Vaeosa> getOtherVaeosasButMeAndBoss(Long myId, Long bossId) {
		try {

			String query = "SELECT v " +
				       "FROM   Vaeosa v " +
				       "WHERE  (v.suletud > :date OR v.suletud IS NULL) " +
				       "  AND  v.vaeosaIdId != :myId " +
				       "  AND  v.vaeosaIdId != :bossId ";
				       		
			return Vaeosa.entityManager()
			             .createQuery(query, Vaeosa.class)
			             .setParameter("myId",   myId)
		                 .setParameter("bossId", bossId)	             
			             .setParameter("date", new Date())
			             .getResultList();
		} catch (EmptyResultDataAccessException e) {
			return null;
		}   	
	}




    
	
}
