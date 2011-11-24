package projekt.web;

import ee.itcollege.team11.Riik;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "riiks", formBackingObject = Riik.class)
@RequestMapping("/riiks")
@Controller
public class RiikController {
}
