package projekt.web;

import ee.itcollege.team11.Vaeosa;
import ee.itcollege.team11.VaeosaAlluvus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "vaeosaalluvuses", formBackingObject = VaeosaAlluvus.class)
@RequestMapping("/vaeosaalluvuses")
@Controller
public class VaeosaAlluvusController {
	
	public static VaeosaAlluvus getVaeosaAlluvusYlemusSuheByVaeosaID(Long vaeosaId) {
		Vaeosa v = Vaeosa.findVaeosa(vaeosaId);
		String otsitavVaeosa = v.getNimetus();
		
		for (VaeosaAlluvus va : VaeosaAlluvus.findAllVaeosaAlluvuses())
		{
			Vaeosa v2 = va.getVaeosa1(); // alluvus
			String leitudVaeosa = v2.getNimetus();
			
			if (va.getVaeosa1().getVaeosaIdId() == vaeosaId)
			{
				return va;
			}
		}
		 
		return null;
	}
}
