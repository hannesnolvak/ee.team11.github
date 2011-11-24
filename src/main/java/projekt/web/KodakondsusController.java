package projekt.web;

import ee.itcollege.team11.Kodakondsus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "kodakondsuses", formBackingObject = Kodakondsus.class)
@RequestMapping("/kodakondsuses")
@Controller
public class KodakondsusController {
}
