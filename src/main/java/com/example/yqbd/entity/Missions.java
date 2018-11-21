package com.example.yqbd.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Missions  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mission_id;
    private String missionname;
    private String missionaddress;
    private int missionpay;
    private String missiondeadline;
    private int maxNumber;
    private String description;
    private String category;
    private int publisherid;
    private String publishtime;
    private int categoryId;
    private String publishername;
    private String publisherphone;
    private String state;

//    @OneToMany(mappedBy = "missions", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Take> takes;
//
//    @OneToMany(mappedBy = "missions", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Apply> applies;
//
//
//    @OneToMany(mappedBy = "missions", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Judge> judges;
//
//
//    @OneToMany(mappedBy = "missions", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Collect> collects;
//
//    @OneToMany(mappedBy = "missions", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Publish> publishes;

    public Missions()
    {

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(int publisherid) {
        this.publisherid = publisherid;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public int getMission_id() {
        return mission_id;
    }

    public void setMission_id(int mission_id) {
        this.mission_id = mission_id;
    }

    public String getMissionname() {
        return missionname;
    }

    public void setMissionname(String missionname) {
        this.missionname = missionname;
    }

    public String getMissionaddress() {
        return missionaddress;
    }

    public void setMissionaddress(String missionaddress) {
        this.missionaddress = missionaddress;
    }

    public int getMissionpay() {
        return missionpay;
    }

    public void setMissionpay(int missionpay) {
        this.missionpay = missionpay;
    }

    public String getMissiondeadline() {
        return missiondeadline;
    }

    public void setMissiondeadline(String missiondeadline) {
        this.missiondeadline = missiondeadline;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublishername() {
        return publishername;
    }

    public void setPublishername(String publishername) {
        this.publishername = publishername;
    }

    public String getPublisherphone() {
        return publisherphone;
    }

    public void setPublisherphone(String publisherphone) {
        this.publisherphone = publisherphone;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
