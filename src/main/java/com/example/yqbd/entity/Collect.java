package com.example.yqbd.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="collect")
public class Collect implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name="user_id")
    private User users;

    @Id
    @ManyToOne
    @JoinColumn(name="mission_id")
    private Missions missions;

    @Column(name="collecttime")
    private String collecttime;

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

    public String getCollecttime() {
        return collecttime;
    }

    public void setCollecttime(String collecttime) {
        this.collecttime = collecttime;
    }
}
