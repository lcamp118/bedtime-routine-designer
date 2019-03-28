package com.lynelleherrera.bedtimeroutinedesigner.Models;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;

//@Entity
public class Activity {

    //@Id
    //@GeneratedValue
    //private int id;

    private String name;
    private int duration;



    public Activity(String name, int duration) {
        //this();
        this.name = name;
        this.duration = duration;
    }

    //public Activity (){ }

    //public int getId() {
    //    return id;
    //}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
