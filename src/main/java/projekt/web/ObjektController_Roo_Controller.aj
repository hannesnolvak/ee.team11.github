// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package projekt.web;

import ee.itcollege.team11.Objekt;
import ee.itcollege.team11.ObjektIntsidendi;
import ee.itcollege.team11.ObjektiLiik;
import ee.itcollege.team11.Piiririkkuja;
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

privileged aspect ObjektController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String ObjektController.create(@Valid Objekt objekt, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("objekt", objekt);
            addDateTimeFormatPatterns(uiModel);
            return "objekts/create";
        }
        uiModel.asMap().clear();
        objekt.persist();
        return "redirect:/objekts/" + encodeUrlPathSegment(objekt.getObjektId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String ObjektController.createForm(Model uiModel) {
        uiModel.addAttribute("objekt", new Objekt());
        addDateTimeFormatPatterns(uiModel);
        return "objekts/create";
    }
    
    @RequestMapping(value = "/{objektId}", method = RequestMethod.GET)
    public String ObjektController.show(@PathVariable("objektId") Long objektId, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("objekt", Objekt.findObjekt(objektId));
        uiModel.addAttribute("itemId", objektId);
        return "objekts/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String ObjektController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("objekts", Objekt.findObjektEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Objekt.countObjekts() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("objekts", Objekt.findAllObjekts());
        }
        addDateTimeFormatPatterns(uiModel);
        return "objekts/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String ObjektController.update(@Valid Objekt objekt, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("objekt", objekt);
            addDateTimeFormatPatterns(uiModel);
            return "objekts/update";
        }
        uiModel.asMap().clear();
        objekt.merge();
        return "redirect:/objekts/" + encodeUrlPathSegment(objekt.getObjektId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{objektId}", params = "form", method = RequestMethod.GET)
    public String ObjektController.updateForm(@PathVariable("objektId") Long objektId, Model uiModel) {
        uiModel.addAttribute("objekt", Objekt.findObjekt(objektId));
        addDateTimeFormatPatterns(uiModel);
        return "objekts/update";
    }
    
    @RequestMapping(value = "/{objektId}", method = RequestMethod.DELETE)
    public String ObjektController.delete(@PathVariable("objektId") Long objektId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Objekt.findObjekt(objektId).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/objekts";
    }
    
    @ModelAttribute("objekts")
    public Collection<Objekt> ObjektController.populateObjekts() {
        return Objekt.findAllObjekts();
    }
    
    @ModelAttribute("objektintsidendis")
    public Collection<ObjektIntsidendi> ObjektController.populateObjektIntsidendis() {
        return ObjektIntsidendi.findAllObjektIntsidendis();
    }
    
    @ModelAttribute("objektiliiks")
    public Collection<ObjektiLiik> ObjektController.populateObjektiLiiks() {
        return ObjektiLiik.findAllObjektiLiiks();
    }
    
    @ModelAttribute("piiririkkujas")
    public Collection<Piiririkkuja> ObjektController.populatePiiririkkujas() {
        return Piiririkkuja.findAllPiiririkkujas();
    }
    
    void ObjektController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("objekt_avatud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("objekt_muudetud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("objekt_suletud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String ObjektController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
