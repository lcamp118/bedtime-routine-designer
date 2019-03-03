package org.launchcode.bedtimeroutinedesigner.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value="add")
    public String displayAddUserForm(Model model){
        return "user/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAddUserForm(Model model){

        return "index";

        }

        }
