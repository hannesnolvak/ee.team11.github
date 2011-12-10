package projekt.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.team11.AdminAlluvus;
import ee.itcollege.team11.RiigiAdminYksus;
import ee.itcollege.team11.RiigiAdminYksuseLiik;

@Controller
@RequestMapping("/aruanne")
public class AruandeController {

	@SuppressWarnings("deprecation")
	@RequestMapping("/aruanne")
	public String vaata(
			@RequestParam(value = "liik", required = false) Long liikId,
			@RequestParam(value = "kp", required = false) String kp,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

//		if(kp == null) kp = new Date();
//		Date kp = new Date(kuupaev);
		
		Date kupaevp = new Date();
		/*
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		if(kp != null) {
			try {
				kupaevp = (Date)formatter.parse(kp);
			} catch (ParseException e) {
				kupaevp = new Date();
			}
		} else {
			kupaevp = new Date();
		} 
		/*
		Date kupaevp;
		if(kp != null) {
			kupaevp = new Date(kp);
		} else {
			kupaevp = new Date();
		}/**/
		
		
		model.addAttribute("liikId", liikId);
//		model.addAttribute("kp", kp == null ? "11-11-2011" : kp);

		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		model.addAttribute("kp", format.format(kupaevp));
		model.addAttribute("kp", kp);
		/**/
		if (kp == null) {
			model.addAttribute("kp", format.format(kupaevp));
		} else {
			try {
				model.addAttribute("kp", format.format(format.parse(kp)));
			} catch (ParseException e) {

			}
		}
		
		
//        Date date = new Date(); //TODO - ei kasuta p2ris kuup2eva
        
//		RiigiAdminYksuseLiik liik = RiigiAdminYksuseLiik.findRiigiAdminYksuseLiik(getLiikId(liikId));
        List<RiigiAdminYksuseLiik> liiks = RiigiAdminYksuseLiik.findAllRiigiAdminYksuseLiiks();
		model.addAttribute("liigid", liiks);
		Collection<AdminAlluvus> units = getAdminAlluvusesByTypeAndDate(liikId, kupaevp);
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