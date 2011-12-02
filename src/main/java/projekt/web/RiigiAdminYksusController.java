package projekt.web;

import java.util.Collection;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        uiModel.addAttribute("alluvad", findChildrens(riigiAdminYksusId));
        
        addDateTimeFormatPatterns(uiModel);
        return "riigiadminyksuses/update";
    }
	
    public Collection<RiigiAdminYksus> findRiigiAdminYksuseVoimalikudAlluvad(Long riigiAdminYksusId) {
    	/*
    	//AdminAlluvus
		//RiigiAdminYksus
		String query = "SELECT y " +
				"FROM RiigiAdminYksus o " +
//				"JOIN o.adminAlluvuses1 a " +
				"JOIN o.riigiAdminYksuseLiik AS yl " +
				"JOIN yl.voimalikAlluvuses2 AS va " +
				"JOIN va.riigiAdminYksuseLiik2 AS yl1 " +
				"JOIN yl1.riigiAdminYksuses AS y " +
				"WHERE o.riigiAdminYksusId = " + riigiAdminYksusId;

		String query = "SELECT a" +
				" FROM RiigiAdminYksus o" +
				" JOIN o.adminAlluvuses1 a" +
				" WHERE o.riigiAdminYksusId = " + riigiAdminYksusId;
		/**/

		String query = "SELECT y2" +
				" FROM RiigiAdminYksus o" +
				" JOIN o.adminAlluvuses1 a" +
				" JOIN a.riigiAdminYksus2 AS y" +
				" JOIN y.riigiAdminYksuseLiik yl" +
				" JOIN yl.riigiAdminYksuses y2" +
				" WHERE o.riigiAdminYksusId = " + riigiAdminYksusId;
		return RiigiAdminYksus.entityManager().createQuery(query, RiigiAdminYksus.class).getResultList();
    }
    
    public Collection<RiigiAdminYksus> findChildrens(Long riigiAdminYksusId) {

		String query = "SELECT y" +
				" FROM RiigiAdminYksus o" +
				" JOIN o.adminAlluvuses2 a" +
				" JOIN a.riigiAdminYksus1 AS y" +
				" WHERE o.riigiAdminYksusId = " + riigiAdminYksusId;
		return RiigiAdminYksus.entityManager().createQuery(query, RiigiAdminYksus.class).getResultList();
    }
}
