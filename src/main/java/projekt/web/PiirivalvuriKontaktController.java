package projekt.web;

import ee.itcollege.team11.PiirivalvuriKontakt;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "piirivalvurikontakts", formBackingObject = PiirivalvuriKontakt.class)
@RequestMapping("/piirivalvurikontakts")
@Controller
public class PiirivalvuriKontaktController {
}
