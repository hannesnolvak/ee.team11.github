package projekt.web;

import ee.itcollege.team11.Ruumiyksus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "ruumiyksuses", formBackingObject = Ruumiyksus.class)
@RequestMapping("/ruumiyksuses")
@Controller
public class RuumiyksusController {
}
