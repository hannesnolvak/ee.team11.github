package projekt.web;

import ee.itcollege.team11.Seadus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "seaduses", formBackingObject = Seadus.class)
@RequestMapping("/seaduses")
@Controller
public class SeadusController {
}
