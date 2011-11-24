package projekt.web;

import ee.itcollege.team11.IsikuSeadusIntsidendi;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "isikuseadusintsidendis", formBackingObject = IsikuSeadusIntsidendi.class)
@RequestMapping("/isikuseadusintsidendis")
@Controller
public class IsikuSeadusIntsidendiController {
}
