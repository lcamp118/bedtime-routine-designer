package com.lynelleherrera.bedtimeroutinedesigner.Controllers;

import com.lynelleherrera.bedtimeroutinedesigner.Models.Data.RoutineDao;
import com.lynelleherrera.bedtimeroutinedesigner.Models.Data.MyUserDao;
import com.lynelleherrera.bedtimeroutinedesigner.Models.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private MyUserDao myUserDao;

    @Autowired
    private RoutineDao routineDao;

    @Resource(name="authenticationManager")
    private AuthenticationManager authenticationManager;

    private UserDetailsService userDetailsService;



    @RequestMapping(value="/", method=RequestMethod.GET)
    public String landingPage (Model model) {
        return "index";
    }
//
//    @RequestMapping(value="/", method=RequestMethod.POST)
//    public String login(Model model) {
//        return "redirect:user/signin";
//    }



    @RequestMapping(value="user/signup", method=RequestMethod.GET)
    public String displayAddUserForm(Model model){
        model.addAttribute(new MyUser());
        return "user/signup";
    }

    @RequestMapping(value="user/signup", method=RequestMethod.POST)
    public String processAddUserForm(Model model, HttpServletRequest request, @ModelAttribute @Valid MyUser myUser, Errors errors){

        if (myUserDao.findByUsername(myUser.getUsername()) !=null){

            model.addAttribute("title","Sign Up");
            return "user/signup";
        }

        if (errors.hasErrors()){

            model.addAttribute("title","Sign Up");
            return "user/signup";

        }

        if (!myUser.getPassword().equals(myUser.getVerify())) {

            model.addAttribute("title", "Sign Up");
            return "user/signup";

        }

        myUser.setPassword(myUser.getPassword());
        myUserDao.save(myUser);

        return "routine/index"; }



    @RequestMapping(value="user/signin", method=RequestMethod.GET)
    public String displayUserSignin(Model model){
        return "user/signin";
    }

    @RequestMapping(value = "signout")
    public String signout() {
        return "redirect:/";
    }

//    @RequestMapping(value="user/signin", method=RequestMethod.POST)
//    public String processUserSignin(Model model, @ModelAttribute MyUser routineUser, String verify){
//        //if errors display sign in form again
//        return "routine/index";
//    }

}
