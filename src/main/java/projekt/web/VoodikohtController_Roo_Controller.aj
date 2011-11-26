// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package projekt.web;

import ee.itcollege.team11.PiirivalvurVodikohal;
import ee.itcollege.team11.Ruumiyksus;
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

privileged aspect VoodikohtController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String VoodikohtController.create(@Valid Voodikoht voodikoht, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("voodikoht", voodikoht);
            addDateTimeFormatPatterns(uiModel);
            return "voodikohts/create";
        }
        uiModel.asMap().clear();
        voodikoht.persist();
        return "redirect:/voodikohts/" + encodeUrlPathSegment(voodikoht.getVoodikohtId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String VoodikohtController.createForm(Model uiModel) {
        uiModel.addAttribute("voodikoht", new Voodikoht());
        addDateTimeFormatPatterns(uiModel);
        return "voodikohts/create";
    }
    
    @RequestMapping(value = "/{voodikohtId}", method = RequestMethod.GET)
    public String VoodikohtController.show(@PathVariable("voodikohtId") Long voodikohtId, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("voodikoht", Voodikoht.findVoodikoht(voodikohtId));
        uiModel.addAttribute("itemId", voodikohtId);
        return "voodikohts/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String VoodikohtController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("voodikohts", Voodikoht.findVoodikohtEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Voodikoht.countVoodikohts() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("voodikohts", Voodikoht.findAllVoodikohts());
        }
        addDateTimeFormatPatterns(uiModel);
        return "voodikohts/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String VoodikohtController.update(@Valid Voodikoht voodikoht, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("voodikoht", voodikoht);
            addDateTimeFormatPatterns(uiModel);
            return "voodikohts/update";
        }
        uiModel.asMap().clear();
        voodikoht.merge();
        return "redirect:/voodikohts/" + encodeUrlPathSegment(voodikoht.getVoodikohtId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{voodikohtId}", params = "form", method = RequestMethod.GET)
    public String VoodikohtController.updateForm(@PathVariable("voodikohtId") Long voodikohtId, Model uiModel) {
        uiModel.addAttribute("voodikoht", Voodikoht.findVoodikoht(voodikohtId));
        addDateTimeFormatPatterns(uiModel);
        return "voodikohts/update";
    }
    
    @RequestMapping(value = "/{voodikohtId}", method = RequestMethod.DELETE)
    public String VoodikohtController.delete(@PathVariable("voodikohtId") Long voodikohtId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Voodikoht.findVoodikoht(voodikohtId).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/voodikohts";
    }
    
    @ModelAttribute("piirivalvurvodikohals")
    public Collection<PiirivalvurVodikohal> VoodikohtController.populatePiirivalvurVodikohals() {
        return PiirivalvurVodikohal.findAllPiirivalvurVodikohals();
    }
    
    @ModelAttribute("ruumiyksuses")
    public Collection<Ruumiyksus> VoodikohtController.populateRuumiyksuses() {
        return Ruumiyksus.findAllRuumiyksuses();
    }
    
    @ModelAttribute("voodikohts")
    public Collection<Voodikoht> VoodikohtController.populateVoodikohts() {
        return Voodikoht.findAllVoodikohts();
    }
    
    void VoodikohtController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("voodikoht_avatud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("voodikoht_muudetud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("voodikoht_suletud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String VoodikohtController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
