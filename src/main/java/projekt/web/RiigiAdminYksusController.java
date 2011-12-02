package projekt.web;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.team11.RiigiAdminYksus;

@RooWebScaffold(path = "riigiadminyksuses", formBackingObject = RiigiAdminYksus.class)
@RequestMapping("/riigiadminyksuses")
@Controller
public class RiigiAdminYksusController {

    @RequestMapping(value = "/{riigiAdminYksusId}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("riigiAdminYksusId") Long riigiAdminYksusId, Model uiModel) {
        uiModel.addAttribute("riigiAdminYksus", RiigiAdminYksus.findRiigiAdminYksus(riigiAdminYksusId));
        uiModel.addAttribute("saaballuda", findRiigiAdminYksuseVoimalikudAlluvad(riigiAdminYksusId));
        
        addDateTimeFormatPatterns(uiModel);
        return "riigiadminyksuses/update";
    }
	
    public Collection<RiigiAdminYksus> findRiigiAdminYksuseVoimalikudAlluvad(Long riigiAdminYksusId) {
		String query = "SELECT y " +
				"FROM RiigiAdminYksus o " +
//				"JOIN o.adminAlluvuses1 a " +
				"JOIN o.riigiAdminYksuseLiik AS yl " +
				"JOIN yl.voimalikAlluvuses2 AS va " +
				"JOIN va.riigiAdminYksuseLiik1 AS yl1 " +
				"JOIN yl1.riigiAdminYksuses AS y " +
				"WHERE o.riigiAdminYksusId = " + riigiAdminYksusId;
		return RiigiAdminYksus.entityManager().createQuery(query, RiigiAdminYksus.class).getResultList();
    }
}
