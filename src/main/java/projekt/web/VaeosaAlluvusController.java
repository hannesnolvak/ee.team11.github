package projekt.web;

import ee.itcollege.team11.VaeosaAlluvus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "vaeosaalluvuses", formBackingObject = VaeosaAlluvus.class)
@RequestMapping("/vaeosaalluvuses")
@Controller
public class VaeosaAlluvusController {
}
