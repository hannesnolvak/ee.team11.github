// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package projekt.web;

import ee.itcollege.team11.AuastmeMuutumine;
import ee.itcollege.team11.Piirivalvur;
import ee.itcollege.team11.PiirivalvurIntsidendi;
import ee.itcollege.team11.PiirivalvurPiiripunkti;
import ee.itcollege.team11.PiirivalvurVaeosa;
import ee.itcollege.team11.PiirivalvurVodikohal;
import ee.itcollege.team11.PiirivalvuriKontakt;
import ee.itcollege.team11.SeotudKontaktisik;
import ee.itcollege.team11.VahtkonnaLiige;
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

privileged aspect PiirivalvurController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String PiirivalvurController.create(@Valid Piirivalvur piirivalvur, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piirivalvur", piirivalvur);
            addDateTimeFormatPatterns(uiModel);
            return "piirivalvurs/create";
        }
        uiModel.asMap().clear();
        piirivalvur.persist();
        return "redirect:/piirivalvurs/" + encodeUrlPathSegment(piirivalvur.getPiirivalvurId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String PiirivalvurController.createForm(Model uiModel) {
        uiModel.addAttribute("piirivalvur", new Piirivalvur());
        addDateTimeFormatPatterns(uiModel);
        return "piirivalvurs/create";
    }
    
    @RequestMapping(value = "/{piirivalvurId}", method = RequestMethod.GET)
    public String PiirivalvurController.show(@PathVariable("piirivalvurId") Long piirivalvurId, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("piirivalvur", Piirivalvur.findPiirivalvur(piirivalvurId));
        uiModel.addAttribute("itemId", piirivalvurId);
        return "piirivalvurs/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String PiirivalvurController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("piirivalvurs", Piirivalvur.findPiirivalvurEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Piirivalvur.countPiirivalvurs() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("piirivalvurs", Piirivalvur.findAllPiirivalvurs());
        }
        addDateTimeFormatPatterns(uiModel);
        return "piirivalvurs/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String PiirivalvurController.update(@Valid Piirivalvur piirivalvur, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piirivalvur", piirivalvur);
            addDateTimeFormatPatterns(uiModel);
            return "piirivalvurs/update";
        }
        uiModel.asMap().clear();
        piirivalvur.merge();
        return "redirect:/piirivalvurs/" + encodeUrlPathSegment(piirivalvur.getPiirivalvurId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{piirivalvurId}", params = "form", method = RequestMethod.GET)
    public String PiirivalvurController.updateForm(@PathVariable("piirivalvurId") Long piirivalvurId, Model uiModel) {
        uiModel.addAttribute("piirivalvur", Piirivalvur.findPiirivalvur(piirivalvurId));
        addDateTimeFormatPatterns(uiModel);
        return "piirivalvurs/update";
    }
    
    @RequestMapping(value = "/{piirivalvurId}", method = RequestMethod.DELETE)
    public String PiirivalvurController.delete(@PathVariable("piirivalvurId") Long piirivalvurId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Piirivalvur.findPiirivalvur(piirivalvurId).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/piirivalvurs";
    }
    
    @ModelAttribute("auastmemuutumines")
    public Collection<AuastmeMuutumine> PiirivalvurController.populateAuastmeMuutumines() {
        return AuastmeMuutumine.findAllAuastmeMuutumines();
    }
    
    @ModelAttribute("piirivalvurs")
    public Collection<Piirivalvur> PiirivalvurController.populatePiirivalvurs() {
        return Piirivalvur.findAllPiirivalvurs();
    }
    
    @ModelAttribute("piirivalvurintsidendis")
    public Collection<PiirivalvurIntsidendi> PiirivalvurController.populatePiirivalvurIntsidendis() {
        return PiirivalvurIntsidendi.findAllPiirivalvurIntsidendis();
    }
    
    @ModelAttribute("piirivalvurpiiripunktis")
    public Collection<PiirivalvurPiiripunkti> PiirivalvurController.populatePiirivalvurPiiripunktis() {
        return PiirivalvurPiiripunkti.findAllPiirivalvurPiiripunktis();
    }
    
    @ModelAttribute("piirivalvurvaeosas")
    public Collection<PiirivalvurVaeosa> PiirivalvurController.populatePiirivalvurVaeosas() {
        return PiirivalvurVaeosa.findAllPiirivalvurVaeosas();
    }
    
    @ModelAttribute("piirivalvurvodikohals")
    public Collection<PiirivalvurVodikohal> PiirivalvurController.populatePiirivalvurVodikohals() {
        return PiirivalvurVodikohal.findAllPiirivalvurVodikohals();
    }
    
    @ModelAttribute("piirivalvurikontakts")
    public Collection<PiirivalvuriKontakt> PiirivalvurController.populatePiirivalvuriKontakts() {
        return PiirivalvuriKontakt.findAllPiirivalvuriKontakts();
    }
    
    @ModelAttribute("seotudkontaktisiks")
    public Collection<SeotudKontaktisik> PiirivalvurController.populateSeotudKontaktisiks() {
        return SeotudKontaktisik.findAllSeotudKontaktisiks();
    }
    
    @ModelAttribute("vahtkonnaliiges")
    public Collection<VahtkonnaLiige> PiirivalvurController.populateVahtkonnaLiiges() {
        return VahtkonnaLiige.findAllVahtkonnaLiiges();
    }
    
    void PiirivalvurController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("piirivalvur_avatud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("piirivalvur_muudetud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("piirivalvur_suletud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String PiirivalvurController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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