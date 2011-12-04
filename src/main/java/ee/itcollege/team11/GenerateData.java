package ee.itcollege.team11;


import java.io.EOFException;
import java.util.Date;
import java.util.List;

import ee.itcollege.team11.RiigiAdminYksuseLiik;


public class GenerateData {

	
	protected static final Date endDate = new Date(253402207200000L);
	
	private Date startOfYear = new Date();
	private Date endOfYear = new Date();
	
	
	public GenerateData() {		
		setStartOfYear();
		setEndOfYear();
		
		genRiigiAdminYksuseLiik();
		genRiigiAdminYksus();	
    	genVaeosaData();
		
	}


	private void genRiigiAdminYksuseLiik() {
		
		List<RiigiAdminYksuseLiik> types = RiigiAdminYksuseLiik.findAllRiigiAdminYksuseLiiks();
		if (types == null || types.size() == 0) {
			RiigiAdminYksuseLiik a = new RiigiAdminYksuseLiik();
			a.setRiigiAdminYksuseLikId(Long.valueOf(1));
			a.setKood("maakond");
			a.setNimetus("Maakond");
			a.setAlates(startOfYear);
			a.setKuni(endOfYear);
			a.persist();
			
			RiigiAdminYksuseLiik b = new RiigiAdminYksuseLiik();
			b.setRiigiAdminYksuseLikId(Long.valueOf(2));
			b.setKood("vald");
			b.setNimetus("Vald");
			b.setAlates(startOfYear);
			b.setKuni(endOfYear);
			b.persist();
		
			RiigiAdminYksuseLiik c = new RiigiAdminYksuseLiik();
			c.setRiigiAdminYksuseLikId(Long.valueOf(3));
			c.setKood("kyla");
			c.setNimetus("Kyla");
			c.setAlates(startOfYear);
			c.setKuni(endOfYear);
			c.persist();
			
			RiigiAdminYksuseLiik d = new RiigiAdminYksuseLiik();
			d.setRiigiAdminYksuseLikId(Long.valueOf(4));
			d.setKood("kihelkond");
			d.setNimetus("Kihelkond");
			d.setAlates(startOfYear);
			d.setKuni(endOfYear);
			d.persist();
			
			
			VoimalikAlluvus va1 = new VoimalikAlluvus();
			va1.setRiigiAdminYksuseLiik2(a);
			va1.setRiigiAdminYksuseLiik1(b);
			va1.persist();
			
			VoimalikAlluvus va2 = new VoimalikAlluvus();
			va2.setRiigiAdminYksuseLiik2(d);
			va2.setRiigiAdminYksuseLiik1(c);
			va2.persist();
			
		}
	}
	
		
			
	private void genRiigiAdminYksus() {
		List<RiigiAdminYksus> yksus = RiigiAdminYksus.findAllRiigiAdminYksuses();
		if (yksus == null || yksus.size() == 0) {
			RiigiAdminYksus a = new RiigiAdminYksus();
			a.setRiigiAdminYksuseLiik(RiigiAdminYksuseLiik.findRiigiAdminYksuseLiik(Long.valueOf(1)));
			a.setKood("347586-23");
			a.setNimetus("Raplamaa");
			a.setAlates(startOfYear);
			a.setKuni(endOfYear);
			a.persist();
			
			RiigiAdminYksus b = new RiigiAdminYksus();
			b.setRiigiAdminYksuseLiik(RiigiAdminYksuseLiik.findRiigiAdminYksuseLiik(Long.valueOf(2)));
			b.setKood("123456-34");
			b.setNimetus("Rapla");
			b.setAlates(startOfYear);
			b.setKuni(endOfYear);
			b.persist();
		
			RiigiAdminYksus c = new RiigiAdminYksus();
			c.setRiigiAdminYksuseLiik(RiigiAdminYksuseLiik.findRiigiAdminYksuseLiik(Long.valueOf(3)));
			c.setKood("98745-12");
			c.setNimetus("Udumuna");
			c.setAlates(startOfYear);
			c.setKuni(endOfYear);
			c.persist();
			
			RiigiAdminYksus d = new RiigiAdminYksus();
			d.setRiigiAdminYksuseLiik(RiigiAdminYksuseLiik.findRiigiAdminYksuseLiik(Long.valueOf(1)));
			d.setKood("98745-10");
			d.setNimetus("Tartumaa");
			d.setAlates(startOfYear);
			d.setKuni(endOfYear);
			d.persist();
				
			RiigiAdminYksus e = new RiigiAdminYksus();
			e.setRiigiAdminYksuseLiik(RiigiAdminYksuseLiik.findRiigiAdminYksuseLiik(Long.valueOf(4)));
			e.setKood("98345-77");
			e.setNimetus("Karupersia_kihelkond");
			e.setAlates(startOfYear);
			e.setKuni(endOfYear);
			e.persist();
			
			
			
			AdminAlluvus a1 = new AdminAlluvus();			
			a1.setRiigiAdminYksus2(a);
			a1.setRiigiAdminYksus1(b);
			a1.persist();
			
			AdminAlluvus a2 = new AdminAlluvus();			
			a2.setRiigiAdminYksus2(d);
			a2.setRiigiAdminYksus1(c);
			a2.persist();
			
			AdminAlluvus a3 = new AdminAlluvus();			
			a3.setRiigiAdminYksus2(d);
			a3.setRiigiAdminYksus1(e);
			a3.persist();
					
		}
	
	
	
	}
		

	@SuppressWarnings("deprecation")
	private void setStartOfYear() {		
		startOfYear.setMonth(1);
				
	}
	

	
	private void setEndOfYear() {
		endOfYear.setMonth(12);
	}
	
	
	
	
	
	
	
	private void genVaeosaData() {
		List<Vaeosa> vaeosas = Vaeosa.findAllVaeosas();
		if (vaeosas == null || vaeosas.size() == 0)
		{
			RiigiAdminYksus koht = RiigiAdminYksus.findRiigiAdminYksus((long) 1);
			
			Vaeosa v1 = new Vaeosa();
			v1.setAlates(startOfYear);
			v1.setKuni(startOfYear);
			v1.setKood("KKJP");
			v1.setNimetus("Kükametsa Üksikjalaväepataljon");
			v1.setRiigiAdminYksus(koht);
			v1.persist();
			
			Vaeosa v2 = new Vaeosa();
			v2.setAlates(startOfYear);
			v2.setKuni(startOfYear);
			v2.setKood("KR1");
			v2.setNimetus("Kükametsa Rühm 1");
			v2.setRiigiAdminYksus(koht);
			v2.persist();
			
			Vaeosa v3 = new Vaeosa();
			v3.setAlates(startOfYear);
			v3.setKuni(startOfYear);
			v3.setKood("KR2");
			v3.setNimetus("Kükametsa Rühm 2");
			v3.setRiigiAdminYksus(koht);
			v3.persist();
			
			
			Vaeosa v4 = new Vaeosa();
			v4.setAlates(startOfYear);
			v4.setKuni(startOfYear);
			v4.setKood("TJP");
			v4.setNimetus("Tartu Üksikjalaväepataljon");
			v4.setRiigiAdminYksus(koht);
			v4.persist();
			
			Vaeosa v5 = new Vaeosa();
			v5.setAlates(startOfYear);
			v5.setKuni(startOfYear);
			v5.setKood("TR1");
			v5.setNimetus("Tartu Rühm1");
			v5.setRiigiAdminYksus(koht);
			v5.persist();
			
			Vaeosa v6 = new Vaeosa();
			v6.setAlates(startOfYear);
			v6.setKuni(startOfYear);
			v6.setKood("TR1");
			v6.setNimetus("Tartu Rühm2");
			v6.setRiigiAdminYksus(koht);
			v6.persist();		
			
			
			VaeosaAlluvus va1 = new VaeosaAlluvus();
			va1.setAlates(startOfYear);
			va1.setKuni(endOfYear);
			va1.setVaeosa2(v1);
			va1.setVaeosa1(v2);
			va1.persist();
			
			VaeosaAlluvus va2 = new VaeosaAlluvus();
			va2.setAlates(startOfYear);
			va2.setKuni(endOfYear);
			va2.setVaeosa2(v1);
			va2.setVaeosa1(v3);
			va2.persist();
			
			VaeosaAlluvus va3 = new VaeosaAlluvus();
			va3.setAlates(startOfYear);
			va3.setKuni(endOfYear);
			va3.setVaeosa2(v4);
			va3.setVaeosa1(v5);
			va3.persist();
			
			VaeosaAlluvus va4 = new VaeosaAlluvus();
			va4.setAlates(startOfYear);
			va4.setKuni(endOfYear);
			va4.setVaeosa2(v4);
			va4.setVaeosa1(v5);
			va4.persist();
			
			
		}
		
	}


}
