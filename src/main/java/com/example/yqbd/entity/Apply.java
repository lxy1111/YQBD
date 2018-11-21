package com.example.yqbd.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="apply")
public class Apply  implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name="user_id")
    private User users;

    @Id
    @ManyToOne
    @JoinColumn(name="mission_id")
    private Missions missions;

    @Column
    private String applytime;

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Missions getMissions() {
        return missions;
    }

    public void setMissions(Missions missions) {
        this.missions = missions;
    }

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }
}