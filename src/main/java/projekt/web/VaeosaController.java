package projekt.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ee.itcollege.team11.Vaeosa;
import ee.itcollege.team11.VaeosaAlluvus;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        uiModel.addAttribute("alluvadVaeosad", Vaeosa.findAlluvadVaeosadByVaeosa(vaeosaIdId));
    	
        
        addDateTimeFormatPatterns(uiModel);
        
    	
        return "vaeosas/update";
    }
	
	/**
	@ModelAttribute("alluvadVaeosad")
	public Collection<Vaeosa> populateAlluvadVaeosad(@PathVariable("vaeosaIdId") Long vaeosaIdId) {
	 String query = "SELECT o FROM Vaeosa o WHERE o.vaeosaIdId = " + vaeosaIdId;
	 System.out.println(vaeosaIdId);
	 return Vaeosa.entityManager().createQuery(query, Vaeosa.class).getResultList();
	}
	
	*/
}
