package com.lynelleherrera.bedtimeroutinedesigner.Controllers;

import com.lynelleherrera.bedtimeroutinedesigner.Models.Activity;
//import com.lynelleherrera.bedtimeroutinedesigner.Models.Data.ActivityDao;
//import org.springframework.beans.factory.annotation.Autowired;
import com.lynelleherrera.bedtimeroutinedesigner.Models.ActivityData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import javax.validation.Valid;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("activity")
public class ActivityController {

    //@Autowired
    //private ActivityDao activityDao;



    @RequestMapping(value="/", method= RequestMethod.GET)
    public String displayActivities(Model model){
        model.addAttribute("title", "All Activities");
        model.addAttribute("activities", ActivityData.getAll());
        //model.addAttribute("activities", activityDao.findAll());

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

        //activityDao.save(newActivity);

        if (errors.hasErrors()){
            model.addAttribute("title", "Add Activity");
            return "activity/add";
        }

        ActivityData.add(newActivity);

        return "redirect:";
    }

}
