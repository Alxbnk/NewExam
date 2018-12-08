package com.example.demo.Services;

import com.example.demo.Models.Event;
import com.example.demo.Repositories.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepo eventRepo;

    @Override
    public List<Event> getEvents() {

        return eventRepo.getEvents();
    }

    @Override
    public Event addEvent(Event event) {

        return eventRepo.addEvent(event);
    }

    @Override
    public Event readEvent(int id) {

        return eventRepo.readEvent(id);
    }

    @Override
    public Event editEvent(int id, Event event) {

        return eventRepo.editEvent(id, event);
    }

    @Override
    public boolean deleteEvent(int id) {

        return eventRepo.deleteEvent(id);
    }
}
