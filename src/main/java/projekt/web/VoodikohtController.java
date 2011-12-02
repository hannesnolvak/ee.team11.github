package projekt.web;

import ee.itcollege.team11.Voodikoht;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "voodikohts", formBackingObject = Voodikoht.class)
@RequestMapping("/voodikohts")
@Controller
public class VoodikohtController {
}
