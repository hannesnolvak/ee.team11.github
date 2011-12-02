package projekt.web;

import ee.itcollege.team11.Auaste;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "auastes", formBackingObject = Auaste.class)
@RequestMapping("/auastes")
@Controller
public class AuasteController {
}
