package projekt.web;

import ee.itcollege.team11.Vahtkond;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "vahtkonds", formBackingObject = Vahtkond.class)
@RequestMapping("/vahtkonds")
@Controller
public class VahtkondController {
}
