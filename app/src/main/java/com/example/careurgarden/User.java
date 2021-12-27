package com.example.careurgarden;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class User implements Serializable {

    private String name;
    private String surname;
    private Date birthday;
    private String email;
    private String password;
    private ArrayList<Plant> garden;

    public User(String name, String surname, Date birthday, String email, String password, ArrayList<Plant> garden) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.garden = garden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public ArrayList<Plant> getGarden() {
        return garden;
    }

    public void setGarden(ArrayList<Plant> garden) {
        this.garden = garden;
    }
}