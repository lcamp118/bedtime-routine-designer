package com.lynelleherrera.bedtimeroutinedesigner.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("activity")
public class ActivityController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String displayActivities(Model model){
        model.addAttribute("title", "All Activities");
        return "activity/index";
    }

    @RequestMapping(value="add", method=RequestMethod.GET)
    public String addActivities(Model model){
        model.addAttribute("title", "Add Activity");
        return "activity/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAddActivitiesForm(Model model){
        model.addAttribute("title", "Add Activity");
        return "activity/index";
    }

}
