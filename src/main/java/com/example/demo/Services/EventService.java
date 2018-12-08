package com.example.demo.Services;

import com.example.demo.Models.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    //EVENTS
    List<Event> getEvents();
    Event addEvent(Event event);
    Event readEvent(int id);
    Event editEvent(int id, Event event);
    boolean deleteEvent(int id);
}
