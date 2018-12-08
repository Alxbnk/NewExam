package com.example.demo.Models;

public class Admin extends User {

    public Admin() {

    }

    public Admin(int id, String username, String password, int role) {
        super(id, username, password, role);
        super.setRole(1);
    }

    @Override
    public String toString() {
        return "Admin{}";
    }

    @Override
    public int getRole() {
        return super.getRole();
    }

    @Override
    public void setRole(int role) {
        super.setRole(1);
    }
}
