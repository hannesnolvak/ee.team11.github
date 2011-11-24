package projekt.web;

import ee.itcollege.team11.PiirivalvurIntsidendi;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "piirivalvurintsidendis", formBackingObject = PiirivalvurIntsidendi.class)
@RequestMapping("/piirivalvurintsidendis")
@Controller
public class PiirivalvurIntsidendiController {
}
