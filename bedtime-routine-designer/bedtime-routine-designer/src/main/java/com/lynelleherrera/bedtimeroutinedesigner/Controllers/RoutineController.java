package com.lynelleherrera.bedtimeroutinedesigner.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("routine")
public class RoutineController {

    @RequestMapping(value="", method=RequestMethod.GET)
    public String displayRoutines(Model model){
        model.addAttribute("title", "My Routines");
        return "routine/index";
    }

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String displayAddRoutineForm(Model model){
        model.addAttribute("title", "Add Routine");
        return "routine/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAddRoutineForm(Model model){
        model.addAttribute("title", "Create Routine");
        return "redirect:";
    }

    //#TODO add delete functionality

}
