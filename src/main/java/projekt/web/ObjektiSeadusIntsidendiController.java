package projekt.web;

import ee.itcollege.team11.ObjektiSeadusIntsidendi;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "objektiseadusintsidendis", formBackingObject = ObjektiSeadusIntsidendi.class)
@RequestMapping("/objektiseadusintsidendis")
@Controller
public class ObjektiSeadusIntsidendiController {
}
