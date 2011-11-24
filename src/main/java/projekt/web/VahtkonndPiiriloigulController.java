package projekt.web;

import ee.itcollege.team11.VahtkonndPiiriloigul;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "vahtkonndpiiriloiguls", formBackingObject = VahtkonndPiiriloigul.class)
@RequestMapping("/vahtkonndpiiriloiguls")
@Controller
public class VahtkonndPiiriloigulController {
}
