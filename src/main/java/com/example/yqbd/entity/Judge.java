package com.example.yqbd.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="judge")
public class Judge implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="user_id")
    private User users;

    @Id
    @ManyToOne
    @JoinColumn(name="mission_id")
    private Missions missions;

    @Column(name="judgetime")
    private String judgetime;

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

    public String getJudgetime() {
        return judgetime;
    }

    public void setJudgetime(String judgetime) {
        this.judgetime = judgetime;
    }
}
