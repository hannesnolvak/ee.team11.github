// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package projekt.web;

import ee.itcollege.team11.KontaktiLiik;
import ee.itcollege.team11.PiirivalvuriKontakt;
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

privileged aspect KontaktiLiikController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String KontaktiLiikController.create(@Valid KontaktiLiik kontaktiLiik, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("kontaktiLiik", kontaktiLiik);
            addDateTimeFormatPatterns(uiModel);
            return "kontaktiliiks/create";
        }
        uiModel.asMap().clear();
        kontaktiLiik.persist();
        return "redirect:/kontaktiliiks/" + encodeUrlPathSegment(kontaktiLiik.getKontaktiLiikId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String KontaktiLiikController.createForm(Model uiModel) {
        uiModel.addAttribute("kontaktiLiik", new KontaktiLiik());
        addDateTimeFormatPatterns(uiModel);
        return "kontaktiliiks/create";
    }
    
    @RequestMapping(value = "/{kontaktiLiikId}", method = RequestMethod.GET)
    public String KontaktiLiikController.show(@PathVariable("kontaktiLiikId") Long kontaktiLiikId, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("kontaktiliik", KontaktiLiik.findKontaktiLiik(kontaktiLiikId));
        uiModel.addAttribute("itemId", kontaktiLiikId);
        return "kontaktiliiks/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String KontaktiLiikController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("kontaktiliiks", KontaktiLiik.findKontaktiLiikEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) KontaktiLiik.countKontaktiLiiks() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("kontaktiliiks", KontaktiLiik.findAllKontaktiLiiks());
        }
        addDateTimeFormatPatterns(uiModel);
        return "kontaktiliiks/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String KontaktiLiikController.update(@Valid KontaktiLiik kontaktiLiik, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("kontaktiLiik", kontaktiLiik);
            addDateTimeFormatPatterns(uiModel);
            return "kontaktiliiks/update";
        }
        uiModel.asMap().clear();
        kontaktiLiik.merge();
        return "redirect:/kontaktiliiks/" + encodeUrlPathSegment(kontaktiLiik.getKontaktiLiikId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{kontaktiLiikId}", params = "form", method = RequestMethod.GET)
    public String KontaktiLiikController.updateForm(@PathVariable("kontaktiLiikId") Long kontaktiLiikId, Model uiModel) {
        uiModel.addAttribute("kontaktiLiik", KontaktiLiik.findKontaktiLiik(kontaktiLiikId));
        addDateTimeFormatPatterns(uiModel);
        return "kontaktiliiks/update";
    }
    
    @RequestMapping(value = "/{kontaktiLiikId}", method = RequestMethod.DELETE)
    public String KontaktiLiikController.delete(@PathVariable("kontaktiLiikId") Long kontaktiLiikId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        KontaktiLiik.findKontaktiLiik(kontaktiLiikId).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/kontaktiliiks";
    }
    
    @ModelAttribute("kontaktiliiks")
    public Collection<KontaktiLiik> KontaktiLiikController.populateKontaktiLiiks() {
        return KontaktiLiik.findAllKontaktiLiiks();
    }
    
    @ModelAttribute("piirivalvurikontakts")
    public Collection<PiirivalvuriKontakt> KontaktiLiikController.populatePiirivalvuriKontakts() {
        return PiirivalvuriKontakt.findAllPiirivalvuriKontakts();
    }
    
    void KontaktiLiikController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("kontaktiLiik_avatud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("kontaktiLiik_muudetud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("kontaktiLiik_suletud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String KontaktiLiikController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
