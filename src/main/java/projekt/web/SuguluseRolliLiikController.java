package projekt.web;

import ee.itcollege.team11.SuguluseRolliLiik;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "suguluserolliliiks", formBackingObject = SuguluseRolliLiik.class)
@RequestMapping("/suguluserolliliiks")
@Controller
public class SuguluseRolliLiikController {
}
