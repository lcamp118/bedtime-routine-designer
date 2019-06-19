package com.lynelleherrera.bedtimeroutinedesigner.Controllers;

import com.lynelleherrera.bedtimeroutinedesigner.Models.Activity;
import com.lynelleherrera.bedtimeroutinedesigner.Models.Data.ActivityDao;
import com.lynelleherrera.bedtimeroutinedesigner.Models.Data.MyUserDao;
import com.lynelleherrera.bedtimeroutinedesigner.Models.Data.RoutineDao;
import com.lynelleherrera.bedtimeroutinedesigner.Models.MyUser;
import com.lynelleherrera.bedtimeroutinedesigner.Models.Routine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private MyUserDao myUserDao;

    @Autowired
    private RoutineDao routineDao;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String displayActivities(Model model){
        model.addAttribute("title", "All Activities");
        model.addAttribute("activities", activityDao.findAll());

        return "activity/index";
    }

    @RequestMapping(value="add", method=RequestMethod.GET)
    public String addActivities(Model model){
        model.addAttribute("title", "Add Activity");
        model.addAttribute(new Activity());
        return "activity/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAddActivitiesForm(@ModelAttribute @Valid Activity newActivity, Errors errors, Model model){

        if (errors.hasErrors()){
            model.addAttribute("title", "Add Activity");
            return "activity/add";
        }

        activityDao.save(newActivity);

        return "redirect:";
    }
    @RequestMapping(value = "routine/{routineId}", method = RequestMethod.GET)
    public String viewActivitiesinRoutine(Model model, @PathVariable int routineId) {

//        MyUser currentUser = MyUser.getCurrentUser();
//        MyUser modelUser = myUserDao.findOne(currentUser.getId());
        Routine myRoutine = routineDao.findOne(routineId);

        model.addAttribute("routine", myRoutine);
        //model.addAttribute("modelUser", modelUser);
        //model.addAttribute(new Activity());

        return "routine/activity";

    }

    @RequestMapping(value="routine/edit/{routineId}", method = RequestMethod.GET)
    public String viewEditRoutineForm(Model model, @PathVariable int routineId){

        Routine myRoutine = routineDao.findOne(routineId);
        model.addAttribute("routine", myRoutine);
        return "routine/edit";

    }

    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String processEditRoutineForm(Model model){
        //#TODO fill this out to grab info from form and save over db object
        return "routine/edit";
    }

    //#TODO fix file path so that routine activities show through the routine controller

}
