package com.example.demo.Models;

public class Rating {

    private int idr;
    private String evaluation;
    private int ascore;
    private int tscore;
    private int idk;
    private int idj;
    private String firstName;
    private String lastName;

    public Rating(int idr, String evaluation, int ascore, int tscore, int idk, int idj, String firstName, String lastName) {
        this.idr = idr;
        this.evaluation = evaluation;
        this.ascore = ascore;
        this.tscore = tscore;
        this.idk = idk;
        this.idj = idj;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Rating() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdj() {
        return idj;
    }

    public void setIdj(int idj) {
        this.idj = idj;
    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public int getAscore() {
        return ascore;
    }

    public void setAscore(int ascore) {
        this.ascore = ascore;
    }

    public int getTscore() {
        return tscore;
    }

    public void setTscore(int tscore) {
        this.tscore = tscore;
    }

    public int getIdk() {
        return idk;
    }

    public void setIdk(int idk) {
        this.idk = idk;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "idr=" + idr +
                ", evaluation='" + evaluation + '\'' +
                ", ascore=" + ascore +
                ", tscore=" + tscore +
                ", idk=" + idk +
                '}';
    }
}

