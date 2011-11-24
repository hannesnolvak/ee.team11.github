package projekt.web;

import ee.itcollege.team11.Piirivalvur;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "piirivalvurs", formBackingObject = Piirivalvur.class)
@RequestMapping("/piirivalvurs")
@Controller
public class PiirivalvurController {
}
