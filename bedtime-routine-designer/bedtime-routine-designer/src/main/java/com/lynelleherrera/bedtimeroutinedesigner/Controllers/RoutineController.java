package com.lynelleherrera.bedtimeroutinedesigner.Controllers;

import com.lynelleherrera.bedtimeroutinedesigner.Models.Activity;
import com.lynelleherrera.bedtimeroutinedesigner.Models.Data.ActivityDao;
import com.lynelleherrera.bedtimeroutinedesigner.Models.Data.RoutineDao;
import com.lynelleherrera.bedtimeroutinedesigner.Models.Routine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
    public String processAddRoutineForm(@ModelAttribute @Valid Routine newRoutine, Errors errors, Model model, @RequestParam int activityId){
        model.addAttribute("title", "Create Routine");

        if (errors.hasErrors()){
            model.addAttribute("title", "Add Routine");
            model.addAttribute("activities", activityDao.findAll());
            return "routine/add";
        }

        Activity activity = activityDao.findOne(activityId);
        newRoutine.addActivity(activity);
        routineDao.save(newRoutine);

        return "redirect:";
    }

    @RequestMapping(value="delete", method=RequestMethod.GET)
    public String displayDeleteRoutineForm(Model model) {
        model.addAttribute("title", "Delete Routines");
        model.addAttribute("routines", routineDao.findAll());
        return "routine/delete";
    }

    @RequestMapping(value="delete", method=RequestMethod.POST)
    public String processDeleteRoutineForm(@RequestParam(required = false) int[] routineIds){
        if (routineIds != null) {
            for (int id : routineIds) {
                routineDao.delete(id);
            }
        }

        return "redirect:";
    }

    //@RequestMapping(value="edit", method=RequestMethod.GET)
    //public String displayEditRoutineForm(Model model) {
    //    model.addAttribute("title", "Edit Routine");
    //    model.addAttribute(new Routine());
    //    model.addAttribute("activities", activityDao.findAll());
     //   return "routine/edit";
    //}
}
