package com.lynelleherrera.bedtimeroutinedesigner.Models;

public class Routine {

    private Activity activity;
    private int bedtime;
    private int routineId;
    private static int nextId = 1;

    public Routine(Activity activity, int bedtime, int routineId) {
        this();
        this.activity = activity;
        this.bedtime = bedtime;
        this.routineId = routineId;
    }

    public Routine (){

        routineId = nextId;
        nextId++;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public int getBedtime() {
        return bedtime;
    }

    public void setBedtime(int bedtime) {
        this.bedtime = bedtime;
    }

    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
    }
}
