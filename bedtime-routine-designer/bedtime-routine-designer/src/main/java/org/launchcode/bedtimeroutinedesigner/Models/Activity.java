package org.launchcode.bedtimeroutinedesigner.Models;

public class Activity {

    private String name;
    private int duration;
    private int activityId;
    private static int nextId = 1;

    public Activity(String name, int duration, int activityId) {
        this();
        this.name = name;
        this.duration = duration;
        this.activityId = activityId;
    }

    public Activity (){

        activityId = nextId;
        nextId++;
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

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
}
