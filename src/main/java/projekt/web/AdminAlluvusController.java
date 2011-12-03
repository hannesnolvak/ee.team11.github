package projekt.web;

import java.util.Date;

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
				"WHERE y.riigiAdminYksusId = :yksus " +
				"AND (a.suletud > :date OR a.suletud IS NULL) " +
				"ORDER BY a.suletud DESC NULLS FIRST";
		return AdminAlluvus.entityManager().createQuery(query, AdminAlluvus.class).setParameter("yksus", adminYksusId).setParameter("date", new Date()).getSingleResult();
	}
}
