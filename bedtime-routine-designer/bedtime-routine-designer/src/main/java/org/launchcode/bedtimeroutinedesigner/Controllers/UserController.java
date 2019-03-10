package org.launchcode.bedtimeroutinedesigner.Controllers;

import org.launchcode.bedtimeroutinedesigner.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class UserController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String main(Model model) {
        return "index";
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String login(Model model) {
        return "redirect:user/signup";
    }



    @RequestMapping(value="user/signup")
    public String displayAddUserForm(Model model){
        return "user/signup";
    }

    @RequestMapping(value="user/signup", method=RequestMethod.POST)
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        model.addAttribute("username", user.getUsername());
        return "user/index"; }



    @RequestMapping(value="user/signin", method=RequestMethod.GET)
    public String displayUserSignin(Model model){
        return "user/signin";
    }

    @RequestMapping(value="user/signin", method=RequestMethod.POST)
    public String processUserSignin(Model model, @ModelAttribute User user, String verify){
        //if errors display sign in form again
        return "redirect:routine/index";
    }
}
