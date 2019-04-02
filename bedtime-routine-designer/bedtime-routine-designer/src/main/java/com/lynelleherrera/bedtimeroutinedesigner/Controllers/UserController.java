//package com.lynelleherrera.bedtimeroutinedesigner.Controllers;
//
//import com.lynelleherrera.bedtimeroutinedesigner.Models.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//
//@Controller
//@RequestMapping("/")
//public class UserController {
//
//    @RequestMapping(value="/", method=RequestMethod.GET)
//    public String landingPage (Model model) {
//        return "index";
//    }
//
//    @RequestMapping(value="/", method=RequestMethod.POST)
//    public String login(Model model) {
//        return "redirect:user/signup";
//    }
//
//
//
//    @RequestMapping(value="user/signup", method=RequestMethod.GET)
//    public String displayAddUserForm(Model model){
//        return "user/signup";
//    }
//
//    @RequestMapping(value="user/signup", method=RequestMethod.POST)
//    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
//        //TODO add validation annotations
//        model.addAttribute("username", user.getUsername());
//        return "routine/index"; }
//
//
//
//    @RequestMapping(value="user/signin", method=RequestMethod.GET)
//    public String displayUserSignin(Model model){
//        return "user/signin";
//    }
//
//    @RequestMapping(value="user/signin", method=RequestMethod.POST)
//    public String processUserSignin(Model model, @ModelAttribute User user, String verify){
//        //TODO add validation annotations
//        //if errors display sign in form again
//        return "routine/index";
//    }
//}
