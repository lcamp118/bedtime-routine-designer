package org.launchcode.bedtimeroutinedesigner.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value="add")
    public String displayAddUserForm(Model model){
        return "user/add";
    }


}
