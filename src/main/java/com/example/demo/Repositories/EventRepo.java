package com.example.demo.Repositories;

import com.example.demo.Models.Event;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo {

    //EVENTS
    java.util.List<Event> getEvents();
    Event addEvent(Event event);
    Event readEvent(int id);
    Event editEvent(int id, Event event);
    boolean deleteEvent(int id);
}
