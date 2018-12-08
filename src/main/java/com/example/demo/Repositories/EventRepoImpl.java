package com.example.demo.Repositories;

import com.example.demo.Models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventRepoImpl implements EventRepo {

    @Autowired
    JdbcTemplate jdbc;

    //EVENTS

    @Override
    public List<Event> getEvents() {

        ArrayList<Event> e = new ArrayList<>();

        String sql = "SELECT name, description, date FROM event";


        // Fra sql til list.
        // Manuelt i stedet.
        return this.jdbc.query(sql, new ResultSetExtractor<List<Event>>() {

            @Override
            public List<Event> extractData(ResultSet rs) throws SQLException, DataAccessException {

                while (rs.next()) {
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String date = rs.getString("date");


                    Event event = new Event(name, description, date);

                    e.add(event);
                }
                return e;
            }
        });
    }

    @Override
    public Event addEvent(Event event) {

        String sql = "INSERT INTO event values (default, ?, ?, ?)";
        jdbc.update(sql, event.getName(), event.getDescription(), event.getDate());

        return event;
    }

    @Override
    public Event readEvent(int id) {
        return null;
    }

    @Override
    public Event editEvent(int id, Event event) {


        String sql = "UPDATE event SET name=?, description=?, date=? WHERE idevent=?";
        jdbc.update(sql, event.getName(), event.getDescription(), event.getDate());
        return event;
    }

    @Override
    public boolean deleteEvent(int id) {
        return false;
    }
}
