package com.example.demo.Controllers;

import com.example.demo.Models.Event;
import com.example.demo.Services.EventService;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    EventService eventService;

    //LOGGER
    Logger log = Logger.getLogger(HomeController.class.getName());


//INDEX

    //RETURN STRING
    private final String INDEX = "index";

    @GetMapping("/")
    public String index(Model model){
        log.info("Index action called...");

        List<Event> e = eventService.getEvents();
        model.addAttribute("events", e);

        userService.loginStatus(model);

        return INDEX;
    }


}
