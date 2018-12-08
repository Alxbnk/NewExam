package com.example.demo.Controllers;

import com.example.demo.Models.*;
import com.example.demo.Services.EventService;
import com.example.demo.Services.RatingService;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    EventService eventService;

    @Autowired
    RatingService ratingService;

    //Logger
    private Logger log = Logger.getLogger(UserController.class.getName());

    //Current User logged in
    private User currentUser = new User();
    private Kitchen currentKitchen = new Kitchen();

//RETURN STRINGS

    //Redirect
    private final String REDIRECT = "redirect:/";

    //LOGIN:
    private final String LOGIN = "Login/login";
    private final String SIGNUP = "Login/signup";

    //INDEX
    private final String INDEX_LOGGED = "index_logged";

    //EVENT
    private final String EVENT = "event";

    //KITCHEN
    private final String KITCHEN = "Kitchen/kitchen";

    //JUDGE
    private final String JUDGE = "Judge/judge";
    private final String EDIT_JUDGE = "Judge/edit_judge";

    //RATING
    private final String GIVE_RATING = "rating/give_rating";

    //OTHER
    private final String FORM = "form";
    private final String ACCEPT = "accept";
    private final String VERIFY = "Admin/verify";


//LOGIN

    //LOGIN
    @GetMapping("/login")
    public String login(Model model) {
        log.info("Get Login called...");

        model.addAttribute("users", new User());
        model.addAttribute("isLogin", true);

        userService.loginStatus(model);

        return LOGIN;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model, RedirectAttributes redirAttr) {
        log.info("Post Login called..");

        boolean loginMatch = false;
        loginMatch = userService.loginMatch(user);

        if (loginMatch == true) {
            redirAttr.addFlashAttribute("loginsuccess", true);
            redirAttr.addFlashAttribute("username", user.getUsername());

            currentUser = userService.loggedIn(user);

            model.addAttribute("role", currentUser.getRole());

            return REDIRECT + INDEX_LOGGED;

        } else {

            redirAttr.addFlashAttribute("loginError", true);

            return REDIRECT + LOGIN;
        }
    }

    //LOGOUT
    @GetMapping("/logout")
    public String logout(Model model){
        log.info("Logout called..");

        currentUser = new User();

        return REDIRECT;
    }

    //SIGN UP
    @GetMapping("/signup")
    public String signup(Model model){
        log.info("Get Signup called...");

        model.addAttribute("user", new User());

        return SIGNUP;
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, Model model,RedirectAttributes redirAttr) {
        log.info("Post Signup called..");

        boolean signUpMatch = false;
        signUpMatch = userService.signUpMatch(user);

        if (signUpMatch == true) {
            redirAttr.addFlashAttribute("loginsuccess", true);
            userService.addUser(user);
            log.info("User created...");
        } else {

            redirAttr.addFlashAttribute("loginError", true);
            log.info("User failed to create...");

            return REDIRECT + SIGNUP;
        }
        return REDIRECT;
    }

//Index logged In

    @GetMapping("/index_logged")
    public String indexLogged(Model model) {
        log.info("IndexLogged called ...");

        List<Event> e = eventService.getEvents();
        model.addAttribute("events", e);
        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("role", currentUser.getRole());

        return INDEX_LOGGED;
    }

//Events logged In

    @GetMapping("/event/logged")
    public String event(Model model) {
        log.info("Event called..");

        List<Kitchen> k = userService.getKitchens();
        model.addAttribute("kitchens", k);

        List<Judge> j = userService.getJudges();
        model.addAttribute("judges", j);

        List<Event> e = eventService.getEvents();
        model.addAttribute("events", e);

        model.addAttribute("role", currentUser.getRole());
        model.addAttribute("username", currentUser.getUsername());

        return EVENT;
    }

//READ Kitchen n Judge

    @GetMapping("/kitchen/{id}")
    public String readKitchen(@PathVariable("id") int id, Model model) {
        log.info("Read kitchen with id: " + id);

        model.addAttribute("kitchen", userService.readKitchen(id));
        model.addAttribute("rating", ratingService.readRating(id));
        model.addAttribute("role", currentUser.getRole());
        model.addAttribute("username", currentUser.getUsername());

        return KITCHEN;
    }

    @GetMapping("/judge/{id}")
    public String readJudge(@PathVariable("id") int id, Model model) {
        log.info("Read judge with id: " + id);

        model.addAttribute("judge", userService.readJudge(id));
        model.addAttribute("role", currentUser.getRole());
        model.addAttribute("username", currentUser.getUsername());

        return JUDGE;
    }

//FORMS

    //Kitchen
    @GetMapping("/kitchen/form")
    public String kitchenForm(Model model) {
        log.info("Get kitchenForm called...");

        model.addAttribute("role", currentUser.getRole());
        model.addAttribute("kitchen", new Kitchen());

        return FORM;
    }

    @PostMapping("/kitchen/form/{id}")
    public String kitchenForm(@PathVariable("id") int id, @ModelAttribute Kitchen kitchen, Model model){
        log.info("Post kitchenForm called + id: " + id);

        kitchen.setIduser(currentUser.getId());
        currentKitchen = userService.addKitchen(kitchen);
        model.addAttribute("role", currentUser.getRole());
        model.addAttribute("kitchens", userService.getKitchens());

        return ACCEPT;
    }

    @GetMapping("/kitchen/accept/{id}")
    public String kitchenAccept(@PathVariable("id") int id,  Model model){
        log.info("Get kitchenAccept called + id: " + id);

        model.addAttribute("role", currentUser.getRole());
        userService.addKitchenToEvent(currentKitchen.getId());

        return ACCEPT;
    }

    //Judge
    @GetMapping("/judge/form")
    public String judgeForm(Model model){
        log.info("Get judgeForm called...");

        model.addAttribute("role", currentUser.getRole());
        model.addAttribute("judge", new Judge());

        return FORM;
    }

    @PostMapping("/judge/form/{id}")
    public String judgeForm(@PathVariable("id") int id, @ModelAttribute Judge judge, Model model){
        log.info("Put judgeForm called + id:" + id);

        judge.setIduser(currentUser.getId());

        userService.addJudge(judge);
        model.addAttribute("judges", userService.getJudges());
        model.addAttribute("role", currentUser.getRole());
        //userService.addJudgeToEvent(judge.getId()); TODO

        return FORM;

    }

    @GetMapping("/judge/accept/{id}")
    public String judgeAccept(@PathVariable("id") int id, Model model){
        log.info("Post judgeAccept called + id: " + id);

        model.addAttribute("role", currentUser.getRole());
        userService.addKitchenToEvent(2);

        return ACCEPT;
    }

//ADMIN EDIT

    @GetMapping("/admin/edit/judge/{id}")
    public String editJudgeAdmin(@PathVariable("id") int id, Model model){
        log.info("Get Edit Judge called as Admin with id: " + id);

        model.addAttribute("role", currentUser.getRole());
        model.addAttribute("judge", userService.readJudge(id));

        return EDIT_JUDGE;
    }

    @PostMapping("/admin/edit/judge/{id}")
    public String editJudgeAdmin(@PathVariable("id") int id, @ModelAttribute Judge judge, Model model){
        log.info("Put Edit Judge called as Admin with id: " + id);

        userService.editJudge(judge);
        model.addAttribute("role", currentUser.getRole());
        model.addAttribute("judge", userService.getJudges());

        return EDIT_JUDGE;
    }

//JUDGE EDIT

    @GetMapping("/judge/edit/judge/{id}")
    public String editJudgeJudge(@PathVariable("id") int id, Model model){
        log.info("Get Edit Judge called as judge with id: " + id);

        model.addAttribute("role", currentUser.getRole());
        model.addAttribute("judge", userService.readJudge(id));

        return EDIT_JUDGE;
    }

    @PostMapping("/judge/edit/judge/{id}")
    public String editJudgeJudge(@PathVariable("id") int id, @ModelAttribute Judge judge, Model model){
        log.info("Put Edit Judge called as Judge with id: " + id);

        userService.editJudge(judge);
        model.addAttribute("role", currentUser.getRole());
        model.addAttribute("judge", userService.getJudges());

        return EDIT_JUDGE;
    }

//VERIFY

    @GetMapping("/admin/verify")
    public String verify(Model model){
        log.info("Verify action called...");

        model.addAttribute("kitchens", userService.getKitchens());
        model.addAttribute("role", currentUser.getRole());
        model.addAttribute("username", currentUser.getUsername());

        return VERIFY;
    }

    @PutMapping("/admin/verify/{id}")
    public String verify(@PathVariable("id") int id, Model model) {
        log.info("Verify put action called...");

        userService.confirmKitchen(id);

        //model.addAttribute("kitchen", userService.getKitchens());
        model.addAttribute("role", currentUser.getRole());
        model.addAttribute("username", currentUser.getUsername());

        return VERIFY;
    }

//RATINGS

    @GetMapping("/rating/give_rating{id}")
    public String giveRating(@PathVariable Integer id, Model model){
        log.info("Get rating action called with id: " + id);

        model.addAttribute("rating", new Rating());
        model.addAttribute("role", currentUser.getRole());

        return GIVE_RATING;
    }

    @PostMapping("/rating/give_rating{id}")
    public String giveRating(@PathVariable Integer id, @ModelAttribute Rating rating, Model model){

        ratingService.giveRating(rating);
        model.addAttribute("role", currentUser.getRole());

        return EVENT;
    }

}
