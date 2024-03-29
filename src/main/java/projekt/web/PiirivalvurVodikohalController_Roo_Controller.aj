// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package projekt.web;

import ee.itcollege.team11.Piirivalvur;
import ee.itcollege.team11.PiirivalvurVodikohal;
import ee.itcollege.team11.Voodikoht;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect PiirivalvurVodikohalController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String PiirivalvurVodikohalController.create(@Valid PiirivalvurVodikohal piirivalvurVodikohal, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piirivalvurVodikohal", piirivalvurVodikohal);
            addDateTimeFormatPatterns(uiModel);
            return "piirivalvurvodikohals/create";
        }
        uiModel.asMap().clear();
        piirivalvurVodikohal.persist();
        return "redirect:/piirivalvurvodikohals/" + encodeUrlPathSegment(piirivalvurVodikohal.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String PiirivalvurVodikohalController.createForm(Model uiModel) {
        uiModel.addAttribute("piirivalvurVodikohal", new PiirivalvurVodikohal());
        addDateTimeFormatPatterns(uiModel);
        return "piirivalvurvodikohals/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String PiirivalvurVodikohalController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("piirivalvurvodikohal", PiirivalvurVodikohal.findPiirivalvurVodikohal(id));
        uiModel.addAttribute("itemId", id);
        return "piirivalvurvodikohals/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String PiirivalvurVodikohalController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("piirivalvurvodikohals", PiirivalvurVodikohal.findPiirivalvurVodikohalEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) PiirivalvurVodikohal.countPiirivalvurVodikohals() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("piirivalvurvodikohals", PiirivalvurVodikohal.findAllPiirivalvurVodikohals());
        }
        addDateTimeFormatPatterns(uiModel);
        return "piirivalvurvodikohals/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String PiirivalvurVodikohalController.update(@Valid PiirivalvurVodikohal piirivalvurVodikohal, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piirivalvurVodikohal", piirivalvurVodikohal);
            addDateTimeFormatPatterns(uiModel);
            return "piirivalvurvodikohals/update";
        }
        uiModel.asMap().clear();
        piirivalvurVodikohal.merge();
        return "redirect:/piirivalvurvodikohals/" + encodeUrlPathSegment(piirivalvurVodikohal.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String PiirivalvurVodikohalController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("piirivalvurVodikohal", PiirivalvurVodikohal.findPiirivalvurVodikohal(id));
        addDateTimeFormatPatterns(uiModel);
        return "piirivalvurvodikohals/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String PiirivalvurVodikohalController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        PiirivalvurVodikohal.findPiirivalvurVodikohal(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/piirivalvurvodikohals";
    }
    
    @ModelAttribute("piirivalvurs")
    public Collection<Piirivalvur> PiirivalvurVodikohalController.populatePiirivalvurs() {
        return Piirivalvur.findAllPiirivalvurs();
    }
    
    @ModelAttribute("piirivalvurvodikohals")
    public Collection<PiirivalvurVodikohal> PiirivalvurVodikohalController.populatePiirivalvurVodikohals() {
        return PiirivalvurVodikohal.findAllPiirivalvurVodikohals();
    }
    
    @ModelAttribute("voodikohts")
    public Collection<Voodikoht> PiirivalvurVodikohalController.populateVoodikohts() {
        return Voodikoht.findAllVoodikohts();
    }
    
    void PiirivalvurVodikohalController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("piirivalvurVodikohal_alates_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("piirivalvurVodikohal_avatud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("piirivalvurVodikohal_kuni_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("piirivalvurVodikohal_muudetud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("piirivalvurVodikohal_suletud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String PiirivalvurVodikohalController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
