package com.lynelleherrera.bedtimeroutinedesigner.Models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Activity {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Max(60)
    private int duration;

    @ManyToMany(mappedBy = "activities")
    private List<Routine> routines = new ArrayList<>();

    public Activity(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public Activity() { }

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

    public int getId() { return id; }

    public List<Routine> getRoutines() {
        return routines;
    }

    private void addRoutine(Routine routine) {
        this.routines.add(routine);
    }
}
