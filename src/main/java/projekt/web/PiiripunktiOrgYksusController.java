package projekt.web;

import ee.itcollege.team11.PiiripunktiOrgYksus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "piiripunktiorgyksuses", formBackingObject = PiiripunktiOrgYksus.class)
@RequestMapping("/piiripunktiorgyksuses")
@Controller
public class PiiripunktiOrgYksusController {
}
