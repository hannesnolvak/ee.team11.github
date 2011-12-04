package projekt.web;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.team11.AdminAlluvus;
import ee.itcollege.team11.RiigiAdminYksus;
import ee.itcollege.team11.RiigiAdminYksuseLiik;
import ee.itcollege.team11.Vaeosa;

@Controller
@RequestMapping("/aruanne")
public class AruandeController {

	@SuppressWarnings("deprecation")
	@RequestMapping("/aruanne")
	public String vaata(
			@RequestParam(value = "liik", required = false) Long liikId,
			@RequestParam(value = "kp", required = false) Date kp,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("liik", liikId);
		model.addAttribute("kp", kp == null ? "11-11-2011" : kp);
		
		
        Date date = new Date(); //TODO - ei kasuta p2ris kuup2eva
        
//		RiigiAdminYksuseLiik liik = RiigiAdminYksuseLiik.findRiigiAdminYksuseLiik(getLiikId(liikId));
		
		model.addAttribute("liigid", RiigiAdminYksuseLiik.findAllRiigiAdminYksuseLiiks());
		Collection<AdminAlluvus> units = getAdminAlluvusesByTypeAndDate(liikId, date);
		model.addAttribute("suhted", units);

		return "aruanne/index";
	}

	
	private Long getLiikId(String liikId) {
		if (liikId == null){
			return getFirstLiikId();					
		}
			
		return Long.parseLong(liikId);
	}

	
	private Long getFirstLiikId() {
		Collection <RiigiAdminYksuseLiik> liiks = RiigiAdminYksuseLiik.findAllRiigiAdminYksuseLiiks();
		for (RiigiAdminYksuseLiik liik : liiks) {
			return liik.getRiigiAdminYksuseLikId();
		}
		return (long) 1;
	}

	
	private Collection<RiigiAdminYksus> findAllUnitsByTypeAndDate(RiigiAdminYksuseLiik type, Date date) {
		
		Collection<RiigiAdminYksus> parentUnits = getParentUnitsByType(type);
		
		
		return null;
	}

	
	private Collection<AdminAlluvus> getAdminAlluvusesByTypeAndDate(Long liikId, Date date) {
		
		try {

			String query = "SELECT    a " +
							"FROM     AdminAlluvus a " +
							"JOIN     a.riigiAdminYksus2 AS ylemus " +
							"JOIN     a.riigiAdminYksus1 AS alluv " +
							"JOIN     ylemus.riigiAdminYksuseLiik AS liik " +
							//"WHERE    a.alates  <= :date " +
							"WHERE    (a.suletud > :date OR a.suletud IS NULL) " +
							"  AND    liik.riigiAdminYksuseLikId = :liikId " +
							"ORDER BY ylemus.nimetus, alluv.nimetus ";
				       		
			return AdminAlluvus.entityManager()
			             .createQuery(query, AdminAlluvus.class)
			             .setParameter("liikId", liikId)		                 	             
   			             .setParameter("date", date)
			             .getResultList();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} 
	}

	
	private Collection<RiigiAdminYksus> getParentUnitsByType(RiigiAdminYksuseLiik type) {
		Collection<RiigiAdminYksus> parentUnits = new ArrayList<RiigiAdminYksus>();
		
		for (RiigiAdminYksus unit : RiigiAdminYksus.findAllRiigiAdminYksuses()) {
			if (unit.getRiigiAdminYksuseLiik().equals(type)){
				parentUnits.add(unit);
			}
				
		};
		
		return parentUnits;
	}
	
	
	/*
    @RequestMapping(value = "/{kuupaev}", params = "raport", method = RequestMethod.GET)
    public String raportKuupaevaga(@PathVariable("kuupaev") Long kuupaev, Model uiModel) {
    	Date date = new Date(kuupaev);
    	uiModel.addAttribute("otsinguTulemus", findSearchResult((date == null ? date : null)));
    	
        addDateTimeFormatPatterns(uiModel);
        return "riigiadminyksuses/raport";
    }
    */
}