package com.lynelleherrera.bedtimeroutinedesigner.Models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Routine {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String title;

    @NotNull
    @Max(24)
    private int bedtime;

    @ManyToOne
    private RoutineUser routineUser;

    @ManyToMany
    private List<Activity> activities;

    public Routine (){ }

    public RoutineUser getRoutineUser() {
        return routineUser;
    }

    public void setRoutineUser(RoutineUser routineUser) {
        this.routineUser = routineUser;
    }

    private void addActivity(Activity task) {
        activities.add(task);
    }

    public int getBedtime() {
        return bedtime;
    }

    public void setBedtime(int bedtime) {
        this.bedtime = bedtime;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Activity> getActivities() { return activities; }
}
