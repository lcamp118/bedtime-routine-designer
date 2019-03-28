package com.lynelleherrera.bedtimeroutinedesigner.Models;

import java.util.ArrayList;

public class ActivityData {

    static ArrayList<Activity> activities = new ArrayList<>();

    //get all
    public static ArrayList<Activity> getAll() {
        return activities;
    }

    //add

    public static void add(Activity newActivity){
        activities.add(newActivity);
    }

    //remove
    public static void remove(int id) {
        Activity activityToRemove = getById(id);
        activities.remove(activityToRemove);
    }

    //getById

    public static Activity getById(int id){

        Activity theActivity = null;

        for (Activity candidateActivity : activities) {
            if (candidateActivity.getActivityId() == id){
                theActivity = candidateActivity;
            }
        }

        return theActivity;
    }

}
