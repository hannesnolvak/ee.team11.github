// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package projekt.web;

import ee.itcollege.team11.RiigiAdminYksuseLiik;
import ee.itcollege.team11.VoimalikAlluvus;
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

privileged aspect VoimalikAlluvusController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String VoimalikAlluvusController.create(@Valid VoimalikAlluvus voimalikAlluvus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("voimalikAlluvus", voimalikAlluvus);
            addDateTimeFormatPatterns(uiModel);
            return "voimalikalluvuses/create";
        }
        uiModel.asMap().clear();
        voimalikAlluvus.persist();
        return "redirect:/voimalikalluvuses/" + encodeUrlPathSegment(voimalikAlluvus.getVoimalikAlluvusId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String VoimalikAlluvusController.createForm(Model uiModel) {
        uiModel.addAttribute("voimalikAlluvus", new VoimalikAlluvus());
        addDateTimeFormatPatterns(uiModel);
        return "voimalikalluvuses/create";
    }
    
    @RequestMapping(value = "/{voimalikAlluvusId}", method = RequestMethod.GET)
    public String VoimalikAlluvusController.show(@PathVariable("voimalikAlluvusId") Long voimalikAlluvusId, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("voimalikalluvus", VoimalikAlluvus.findVoimalikAlluvus(voimalikAlluvusId));
        uiModel.addAttribute("itemId", voimalikAlluvusId);
        return "voimalikalluvuses/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String VoimalikAlluvusController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("voimalikalluvuses", VoimalikAlluvus.findVoimalikAlluvusEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) VoimalikAlluvus.countVoimalikAlluvuses() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("voimalikalluvuses", VoimalikAlluvus.findAllVoimalikAlluvuses());
        }
        addDateTimeFormatPatterns(uiModel);
        return "voimalikalluvuses/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String VoimalikAlluvusController.update(@Valid VoimalikAlluvus voimalikAlluvus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("voimalikAlluvus", voimalikAlluvus);
            addDateTimeFormatPatterns(uiModel);
            return "voimalikalluvuses/update";
        }
        uiModel.asMap().clear();
        voimalikAlluvus.merge();
        return "redirect:/voimalikalluvuses/" + encodeUrlPathSegment(voimalikAlluvus.getVoimalikAlluvusId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{voimalikAlluvusId}", params = "form", method = RequestMethod.GET)
    public String VoimalikAlluvusController.updateForm(@PathVariable("voimalikAlluvusId") Long voimalikAlluvusId, Model uiModel) {
        uiModel.addAttribute("voimalikAlluvus", VoimalikAlluvus.findVoimalikAlluvus(voimalikAlluvusId));
        addDateTimeFormatPatterns(uiModel);
        return "voimalikalluvuses/update";
    }
    
    @RequestMapping(value = "/{voimalikAlluvusId}", method = RequestMethod.DELETE)
    public String VoimalikAlluvusController.delete(@PathVariable("voimalikAlluvusId") Long voimalikAlluvusId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        VoimalikAlluvus.findVoimalikAlluvus(voimalikAlluvusId).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/voimalikalluvuses";
    }
    
    @ModelAttribute("riigiadminyksuseliiks")
    public Collection<RiigiAdminYksuseLiik> VoimalikAlluvusController.populateRiigiAdminYksuseLiiks() {
        return RiigiAdminYksuseLiik.findAllRiigiAdminYksuseLiiks();
    }
    
    @ModelAttribute("voimalikalluvuses")
    public Collection<VoimalikAlluvus> VoimalikAlluvusController.populateVoimalikAlluvuses() {
        return VoimalikAlluvus.findAllVoimalikAlluvuses();
    }
    
    void VoimalikAlluvusController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("voimalikAlluvus_avatud_date_format", "yyyy-MM-DD");
        uiModel.addAttribute("voimalikAlluvus_muudetud_date_format", "yyyy-MM-DD");
        uiModel.addAttribute("voimalikAlluvus_suletud_date_format", "yyyy-MM-DD");
    }
    
    String VoimalikAlluvusController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
