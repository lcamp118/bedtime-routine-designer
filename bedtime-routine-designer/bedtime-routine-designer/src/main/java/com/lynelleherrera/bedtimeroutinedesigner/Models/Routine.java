package com.lynelleherrera.bedtimeroutinedesigner.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Routine {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Max(24)
    private int bedtime;

    @ManyToMany
    private List<Activity> activities;

    public Routine (){ }

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

    public List<Activity> getActivities() { return activities; }
}
