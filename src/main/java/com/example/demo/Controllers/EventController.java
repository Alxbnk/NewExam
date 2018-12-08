package com.example.demo.Controllers;

import com.example.demo.Models.Event;
import com.example.demo.Models.Judge;
import com.example.demo.Models.Kitchen;
import com.example.demo.Services.EventService;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class EventController {

    @Autowired
    UserService userService;

    @Autowired
    EventService eventService;



    //LOGGER
    Logger log = Logger.getLogger(EventController.class.getName());

    //Return Strings
    private final String EVENT = "event";

    @GetMapping("/event")
    public String event(Model model){
        log.info("See event action called..");

        List<Kitchen> k = userService.getKitchens();
        model.addAttribute("kitchens", k);

        List<Judge> j = userService.getJudges();
        model.addAttribute("judges", j);

        List<Event> e = eventService.getEvents();
        model.addAttribute("events", e);

        return EVENT;

    }
}
