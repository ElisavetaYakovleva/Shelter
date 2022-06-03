package com.example.Shelter.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName, dogName, phone, email, goal, answers, control;

    public Owner() {
    }

    public Owner(String userName, String dogName, String phone, String email, String goal, String answers, String control) {
        this.userName = userName;
        this.dogName = dogName;
        this.phone = phone;
        this.email = email;
        this.goal = goal;
        this.answers = answers;
        this.control = control;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }
}
