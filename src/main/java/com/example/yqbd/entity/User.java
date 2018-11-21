package com.example.yqbd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String password;
    private String phone;
    private String realname;
    private String user_address;
    private String corporation;
    private String headimage;
    private String title;
    private int  star;
    private String gender;;
    private String job;
    private int age;

//    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Take> takes;
//
//    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Apply> applies;
//
//    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Judge> judges ;
//
//
//    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Collect> collects ;
//
//    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Publish> publishes ;

    public User()
    {

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //    public Set<Take> getTakes() {
//        return takes;
//    }
//
//    public void setTakes(Set<Take> takes) {
//        this.takes = takes;
//    }
//
//    public Set<Apply> getApplies() {
//        return applies;
//    }
//
//    public void setApplies(Set<Apply> applies) {
//        this.applies = applies;
//    }
//
//
//    public Set<Judge> getJudges() {
//        return judges;
//    }
//
//    public void setJudges(Set<Judge> judges) {
//        this.judges = judges;
//    }
//
//
//    public Set<Collect> getCollects() {
//        return collects;
//    }
//
//    public void setCollects(Set<Collect> collects) {
//        this.collects = collects;
//    }
//
//    public Set<Publish> getPublishes() {
//        return publishes;
//    }
//
//    public void setPublishes(Set<Publish> publishes) {
//        this.publishes = publishes;
//    }
}

