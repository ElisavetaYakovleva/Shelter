package com.example.Shelter.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, gender, discr, url;
    private LocalDate dob;

    public Dog() {
    }

    public Dog(String name, String gender, String discr, String url, LocalDate dob) {
        this.name = name;
        this.gender = gender;
        this.discr = discr;
        this.url = url;
        this.dob = dob;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDiscr(String discr) {
        this.discr = discr;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
    public String getGender() {
        return gender;
    }

    public String getDiscr() {
        return discr;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public int getAge(){
        int a = Period.between(dob, LocalDate.now()).getYears();
        int b = Period.between(dob, LocalDate.now()).getMonths();
        if (a == 0) {return b;}
        else { return 12*a + b; }
    }

}
