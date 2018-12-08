package com.example.demo.Models;

public class Kitchen extends User{

    private int idk;
    private String name;
    private String address;
    private String description;
    private String picture;
    private int iduser;
    private boolean verified = false;

    public Kitchen(String name, String address, String description, String picture, int idk, int iduser, boolean verified) {
        this.idk = idk;
        this.name = name;
        this.address = address;
        this.description = description;
        this.picture = picture;
        this.iduser = iduser;
        this.verified = verified;
    }

    public Kitchen(int id, String username, String password, int role, int idk, String name, String address, String description, String picture, int iduser, boolean verified) {
        super(id, username, password, role);
        this.idk = idk;
        this.name = name;
        this.address = address;
        this.description = description;
        this.picture = picture;
        this.iduser = iduser;
        this.verified = verified;
        super.setRole(2);
    }

    public Kitchen() {

    }

    public int getIdk() {
        return idk;
    }

    public void setIdk(int idk) {
        this.idk = idk;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public int getRole() {
        return super.getRole();
    }

    @Override
    public void setRole(int role) {
        super.setRole(2);
    }

    @Override
    public String toString() {
        return "Kitchen{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", verified=" + verified +
                '}';
    }
}
