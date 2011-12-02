package projekt.web;

import ee.itcollege.team11.SeadusePunkt;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "seadusepunkts", formBackingObject = SeadusePunkt.class)
@RequestMapping("/seadusepunkts")
@Controller
public class SeadusePunktController {
}
