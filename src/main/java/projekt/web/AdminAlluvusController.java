package projekt.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ee.itcollege.team11.AdminAlluvus;

@RooWebScaffold(path = "adminalluvuses", formBackingObject = AdminAlluvus.class)
@RequestMapping("/adminalluvuses")
@Controller
public class AdminAlluvusController {
	
	public static AdminAlluvus getAdminYksusAlluvus(Long adminYksusId) {
		String query = "SELECT a " +
				"FROM AdminAlluvus a " +
				"JOIN a.riigiAdminYksus1 AS y " +
				"WHERE y.riigiAdminYksusId = " + adminYksusId + " " +
				"ORDER BY y.riigiAdminYksusId DESC";
		return AdminAlluvus.entityManager().createQuery(query, AdminAlluvus.class).getSingleResult();
	}
    /*
    public AdminAlluvus get(Long adminAlluvusId) {
        AdminAlluvus.findAdminAlluvus(adminAlluvusId).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/adminalluvuses";
    }
    /*
    @RequestMapping(method = RequestMethod.PUT)
    public String AdminAlluvusController.update(@Valid AdminAlluvus adminAlluvus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("adminAlluvus", adminAlluvus);
            addDateTimeFormatPatterns(uiModel);
            return "adminalluvuses/update";
        }
        uiModel.asMap().clear();
        adminAlluvus.merge();
        return "redirect:/adminalluvuses/" + encodeUrlPathSegment(adminAlluvus.getAdminAlluvusId().toString(), httpServletRequest);
    }/**/
    /*
    @RequestMapping(value = "/{adminAlluvusId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("adminAlluvusId") Long adminAlluvusId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
    	AdminAlluvus adminAlluvus = AdminAlluvus.findAdminAlluvus(adminAlluvusId);
        uiModel.asMap().clear();
        adminAlluvus.merge();
//        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
//        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/adminalluvuses";
    }
    /*
    @RequestMapping(value = "/{adminAlluvusId}", method = RequestMethod.DELETE)
    public String AdminAlluvusController.delete(@PathVariable("adminAlluvusId") Long adminAlluvusId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        AdminAlluvus.findAdminAlluvus(adminAlluvusId).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/adminalluvuses";
    }/**/
}
