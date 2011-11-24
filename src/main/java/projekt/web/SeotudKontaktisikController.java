package projekt.web;

import ee.itcollege.team11.SeotudKontaktisik;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "seotudkontaktisiks", formBackingObject = SeotudKontaktisik.class)
@RequestMapping("/seotudkontaktisiks")
@Controller
public class SeotudKontaktisikController {
}
