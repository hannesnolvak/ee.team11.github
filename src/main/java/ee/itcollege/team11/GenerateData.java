package ee.itcollege.team11;


import java.util.Date;
import java.util.List;

import ee.itcollege.team11.RiigiAdminYksuseLiik;


public class GenerateData {

	
	protected static final Date endDate = new Date(253402207200000L);
	
	public GenerateData() {		
		genRiigiAdminYksuseLiik();
		
		
	}

	private void genRiigiAdminYksuseLiik() {
		List<RiigiAdminYksuseLiik> types = RiigiAdminYksuseLiik.findAllRiigiAdminYksuseLiiks();
		if (types == null || types.size() == 0) {
			RiigiAdminYksuseLiik a = new RiigiAdminYksuseLiik();
			a.setRiigiAdminYksuseLikId(Long.valueOf(15));
			a.setKood("maakond");
			a.setNimetus("Raplamaa");
			a.setAlates(new Date());
			a.setKuni(new Date());
			a.persist();
		}
		
		

	
	}
}
