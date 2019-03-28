package com.lynelleherrera.bedtimeroutinedesigner.Models;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;

//@Entity
public class Activity {

    //@Id
    //@GeneratedValue
    private int activityId;

    private String name;
    private int duration;
    private static int nextId = 1;



    public Activity(String name, int duration) {
        this();
        this.name = name;
        this.duration = duration;
    }

    public Activity() {
        activityId = nextId;
        nextId ++;
    }

    //public Activity (){ }

    //public int getId() {
    //    return id;
    //}


    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

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
