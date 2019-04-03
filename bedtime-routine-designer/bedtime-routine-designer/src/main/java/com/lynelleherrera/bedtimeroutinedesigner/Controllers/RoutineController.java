package com.lynelleherrera.bedtimeroutinedesigner.Controllers;

import com.lynelleherrera.bedtimeroutinedesigner.Models.Data.ActivityDao;
import com.lynelleherrera.bedtimeroutinedesigner.Models.Data.RoutineDao;
import com.lynelleherrera.bedtimeroutinedesigner.Models.Routine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("routine")
public class RoutineController {

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private RoutineDao routineDao;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String displayRoutines(Model model){
        model.addAttribute("title", "My Routines");
        model.addAttribute("routines", routineDao.findAll());
        return "routine/index";
    }

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String displayAddRoutineForm(Model model){
        model.addAttribute("title", "Add Routine");
        model.addAttribute(new Routine());
        model.addAttribute("activities", activityDao.findAll());
        return "routine/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAddRoutineForm(@ModelAttribute @Valid Routine newRoutine, Errors errors, Model model){
        model.addAttribute("title", "Create Routine");

        if (errors.hasErrors()){
            model.addAttribute("title", "Add Routine");
            return "routine/add";
        }

        routineDao.save(newRoutine);

        return "redirect:";
    }

    //#TODO add delete functionality

}
