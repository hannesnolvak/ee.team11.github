package projekt.web;

import ee.itcollege.team11.IntsidendiLiik;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "intsidendiliiks", formBackingObject = IntsidendiLiik.class)
@RequestMapping("/intsidendiliiks")
@Controller
public class IntsidendiLiikController {
}
