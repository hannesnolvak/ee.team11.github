// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package projekt.web;

import ee.itcollege.team11.Piiripunkt;
import ee.itcollege.team11.PiiripunktiAlluvus;
import ee.itcollege.team11.Vaeosa;
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

privileged aspect PiiripunktiAlluvusController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String PiiripunktiAlluvusController.create(@Valid PiiripunktiAlluvus piiripunktiAlluvus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piiripunktiAlluvus", piiripunktiAlluvus);
            addDateTimeFormatPatterns(uiModel);
            return "piiripunktialluvuses/create";
        }
        uiModel.asMap().clear();
        piiripunktiAlluvus.persist();
        return "redirect:/piiripunktialluvuses/" + encodeUrlPathSegment(piiripunktiAlluvus.getPiiripunktiAlluvusId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String PiiripunktiAlluvusController.createForm(Model uiModel) {
        uiModel.addAttribute("piiripunktiAlluvus", new PiiripunktiAlluvus());
        addDateTimeFormatPatterns(uiModel);
        return "piiripunktialluvuses/create";
    }
    
    @RequestMapping(value = "/{piiripunktiAlluvusId}", method = RequestMethod.GET)
    public String PiiripunktiAlluvusController.show(@PathVariable("piiripunktiAlluvusId") Long piiripunktiAlluvusId, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("piiripunktialluvus", PiiripunktiAlluvus.findPiiripunktiAlluvus(piiripunktiAlluvusId));
        uiModel.addAttribute("itemId", piiripunktiAlluvusId);
        return "piiripunktialluvuses/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String PiiripunktiAlluvusController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("piiripunktialluvuses", PiiripunktiAlluvus.findPiiripunktiAlluvusEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) PiiripunktiAlluvus.countPiiripunktiAlluvuses() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("piiripunktialluvuses", PiiripunktiAlluvus.findAllPiiripunktiAlluvuses());
        }
        addDateTimeFormatPatterns(uiModel);
        return "piiripunktialluvuses/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String PiiripunktiAlluvusController.update(@Valid PiiripunktiAlluvus piiripunktiAlluvus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piiripunktiAlluvus", piiripunktiAlluvus);
            addDateTimeFormatPatterns(uiModel);
            return "piiripunktialluvuses/update";
        }
        uiModel.asMap().clear();
        piiripunktiAlluvus.merge();
        return "redirect:/piiripunktialluvuses/" + encodeUrlPathSegment(piiripunktiAlluvus.getPiiripunktiAlluvusId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{piiripunktiAlluvusId}", params = "form", method = RequestMethod.GET)
    public String PiiripunktiAlluvusController.updateForm(@PathVariable("piiripunktiAlluvusId") Long piiripunktiAlluvusId, Model uiModel) {
        uiModel.addAttribute("piiripunktiAlluvus", PiiripunktiAlluvus.findPiiripunktiAlluvus(piiripunktiAlluvusId));
        addDateTimeFormatPatterns(uiModel);
        return "piiripunktialluvuses/update";
    }
    
    @RequestMapping(value = "/{piiripunktiAlluvusId}", method = RequestMethod.DELETE)
    public String PiiripunktiAlluvusController.delete(@PathVariable("piiripunktiAlluvusId") Long piiripunktiAlluvusId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        PiiripunktiAlluvus.findPiiripunktiAlluvus(piiripunktiAlluvusId).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/piiripunktialluvuses";
    }
    
    @ModelAttribute("piiripunkts")
    public Collection<Piiripunkt> PiiripunktiAlluvusController.populatePiiripunkts() {
        return Piiripunkt.findAllPiiripunkts();
    }
    
    @ModelAttribute("piiripunktialluvuses")
    public Collection<PiiripunktiAlluvus> PiiripunktiAlluvusController.populatePiiripunktiAlluvuses() {
        return PiiripunktiAlluvus.findAllPiiripunktiAlluvuses();
    }
    
    @ModelAttribute("vaeosas")
    public Collection<Vaeosa> PiiripunktiAlluvusController.populateVaeosas() {
        return Vaeosa.findAllVaeosas();
    }
    
    void PiiripunktiAlluvusController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("piiripunktiAlluvus_avatud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("piiripunktiAlluvus_muudetud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("piiripunktiAlluvus_suletud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String PiiripunktiAlluvusController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
