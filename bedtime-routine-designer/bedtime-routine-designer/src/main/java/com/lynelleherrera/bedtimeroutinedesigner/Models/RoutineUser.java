package com.lynelleherrera.bedtimeroutinedesigner.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RoutineUser {

    @GeneratedValue
    @Id
    private int id;

    @NotNull
    @Size(min=1)
    private String firstName;

    @NotNull
    @Size(min=1)
    private String lastName;

    @NotNull
    @Size(min=3, max=15)
    private String username;

    @NotNull
    @Size(min=8, max=15)
    private String password;
    private String verify;

    public RoutineUser(String firstName, String lastName, String email, String password, String verify) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.verify = verify;
    }

    @OneToMany
    @JoinColumn(name= "user_id")
    private List<Routine> routines = new ArrayList<>();

    public RoutineUser() {}

    public int getId() {
        return id;
    }

    public List<Routine> getRoutines() {
        return routines;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}