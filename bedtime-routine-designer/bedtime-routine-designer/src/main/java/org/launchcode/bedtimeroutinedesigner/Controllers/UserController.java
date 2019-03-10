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

    @RequestMapping(value="/")
    public String main(Model model) {
        return "index";
    }

    @RequestMapping(value="add")
    public String displayAddUserForm(Model model){
        return "user/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        model.addAttribute("username", user.getUsername());
        return "user/index";

        }

        }
