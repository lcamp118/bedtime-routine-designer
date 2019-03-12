package com.lynelleherrera.bedtimeroutinedesigner.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("routine")
public class RoutineController {

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String displayAddRoutineForm(Model model){
        model.addAttribute("title", "Add Routine");
        return "routine/add";
    }

}
