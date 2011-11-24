package projekt.web;

import ee.itcollege.team11.KontaktiLiik;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "kontaktiliiks", formBackingObject = KontaktiLiik.class)
@RequestMapping("/kontaktiliiks")
@Controller
public class KontaktiLiikController {
}
