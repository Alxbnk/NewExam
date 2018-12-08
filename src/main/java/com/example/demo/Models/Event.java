package com.example.demo.Models;

import java.util.ArrayList;
import java.util.Date;

public class Event {

    private String name;
    private String description;
    private String date;
    private ArrayList<Judge> judges;
    private ArrayList<Kitchen> kitchens;

    public Event(String name, String description, String date, ArrayList<Judge> judges, ArrayList<Kitchen> kitchens) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.judges = judges;
        this.kitchens = kitchens;
    }

    public Event(String name, String description, String date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public Event() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Judge> getJudges() {
        return judges;
    }

    public void setJudges(ArrayList<Judge> judges) {
        this.judges = judges;
    }

    public ArrayList<Kitchen> getKitchens() {
        return kitchens;
    }

    public void setKitchens(ArrayList<Kitchen> kitchens) {
        this.kitchens = kitchens;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", judges=" + judges +
                ", kitchens=" + kitchens +
                '}';
    }
}


