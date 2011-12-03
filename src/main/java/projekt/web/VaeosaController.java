package projekt.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.itcollege.team11.Vaeosa;
import ee.itcollege.team11.VaeosaAlluvus;

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
    	
        
        addDateTimeFormatPatterns(uiModel);
        
    	
        return "vaeosas/update";
    }
	
    

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid Vaeosa vaeosa, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	//VaeosaAlluvus va = VaeosaAlluvusController.getVaeosaAlluvusYlemusSuheByVaeosaID(vaeosa.getVaeosaIdId());
    	
    	//va.setVaeosa2(vaeosa.getAjutineVaeosa());
    	//va.merge();
    
    	
    	if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vaeosa", vaeosa);
            addDateTimeFormatPatterns(uiModel);
            return "vaeosas/update";
        }
        uiModel.asMap().clear();
        vaeosa.merge();
        return "redirect:/vaeosas/" + encodeUrlPathSegment(vaeosa.getVaeosaIdId().toString(), httpServletRequest);
    }
    
	
}
