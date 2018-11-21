package com.example.yqbd.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.yqbd.Dao.missionDao;
import com.example.yqbd.entity.Missions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/missions")
public class missionController {

    @Autowired
    private missionDao missionDao;

    public boolean checkMission(String missionname)
    {
        List<Missions> list=missionDao.findByMissionname(missionname);
        if(list.size()>0) {
            return false;
        }
            return true;
    }
    public boolean checkDoubleIdentity(int applicantid,int missionid)
    {
        List<Missions> list=missionDao.checkIfTheUserIsPublisher(applicantid,missionid);
        if(list.size()>0)
        {
            return false;
        }
        return true;
    }
    public boolean checkApply(int applicantid,int missionid)
    {
        List list=missionDao.checkApply(applicantid,missionid);
        if(list.size()>0)
        {
            return false;
        }
        return true;
    }

    public boolean checkTake(int userid,int missionid)
    {
        List list=missionDao.checkTake(userid,missionid);
        if(list.size()>0)
        {
            return false;
        }
        return true;
    }

    public boolean checkCollection(int userid,int missionid)
    {
        List list= missionDao.checkCollection(userid,missionid);
        if(list.size()>0)
        {
            return false;
        }
        return true;
    }


    @PostMapping("addmissions")
    @CrossOrigin(origins ="*")
    public boolean addMission(@RequestParam(value="message") String message) throws ParseException {
        JSONObject json=JSONObject.parseObject(message);
        String missionname=json.get("missionname").toString();
        String missionaddress=json.get("missionaddress").toString();
        String description =json.get("description").toString();
        int categoryId=Integer.parseInt(json.get("categoryId").toString());
        int missionpay=Integer.parseInt(json.get("missionpay").toString());
        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        DateFormat formatdatetime = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
        String missiondeadline=json.get("missiondeadline").toString();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String category=json.get("category").toString();
        int maxnumber=Integer.parseInt(json.get("maxnumber").toString());
        int publisherid=Integer.parseInt(json.get("publisherid").toString());
        String publishername=json.get("publishername").toString();
        String publisherphone=json.get("publisherphone").toString();
        Date date=new Date();

        String publishtime=formatdatetime.format(date);
        if(checkMission(missionname)) {
            Missions mission = new Missions();
            mission.setMissionname(missionname);
            mission.setMissionaddress(missionaddress);
            mission.setMaxNumber(maxnumber);
            mission.setCategory(category);
            mission.setDescription(description);
            mission.setMissiondeadline(missiondeadline);
            mission.setPublisherid(publisherid);
            mission.setPublishtime(publishtime);
            mission.setMissionpay(missionpay);
            mission.setCategoryId(categoryId);
            mission.setPublishername(publishername);
            mission.setPublisherphone(publisherphone);
            mission.setState("未开始");
            missionDao.save(mission);
            return true;
        }
        else
        {
            return false;
        }
    }

    @PostMapping("applyformissions")
    @CrossOrigin(origins ="*")
    public boolean applyForMissions(@RequestParam(value="message") String message)
    {
        JSONObject json=JSONObject.parseObject(message);
        int missionid=Integer.parseInt(json.get("missionid").toString());
        int applicantid=Integer.parseInt(json.get("applicantid").toString());
        String experience=json.get("experience").toString();
        String applyreason=json.get("applyreason").toString();
        System.out.println(missionid);
        System.out.println(applicantid);
        if(!checkDoubleIdentity(applicantid,missionid)||!checkApply(applicantid,missionid)) {
            return false;
        }
        System.out.println("hello"+applicantid);
        Date date=new Date();
        DateFormat formatdatetime = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
        String applytime=formatdatetime.format(date);
        System.out.println(applicantid);
        System.out.println(missionid);
        missionDao.applyForMissions(applicantid,missionid,applytime,experience,applyreason);
        return true;
    }

    @PostMapping("collectmissions")
    @CrossOrigin(origins ="*")
    public boolean collectMissions(@RequestParam(value="message") String message)
    {
        JSONObject json=JSONObject.parseObject(message);
        int missionid=Integer.parseInt(json.get("missionid").toString());
        int userid=Integer.parseInt(json.get("userid").toString());
        if(!checkCollection(userid,missionid))
        {
            return false;
        }
        Date date=new Date();
        DateFormat formatdatetime = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
        String collecttime=formatdatetime.format(date);
        missionDao.collectMissions(userid,missionid,collecttime);
        return true;
    }

    @PostMapping("getappliedreason")
    @CrossOrigin(origins ="*")
    public String getAppliedReason(@RequestParam(value="message") String message)
    {
        JSONObject json=JSONObject.parseObject(message);
        int userid=Integer.parseInt(json.get("userid").toString());
        int missionid=Integer.parseInt(json.get("missionid").toString());
        System.out.println("hello"+userid);
        return missionDao.getApplyReason(userid,missionid);
    }

    @PostMapping("passApplicants")
    @CrossOrigin(origins ="*")
    public boolean passApplicants(@RequestParam(value="message") String message)
    {
        JSONObject json=JSONObject.parseObject(message);
        int userid=Integer.parseInt(json.get("userid").toString());
        int missionid=Integer.parseInt(json.get("missionid").toString());
        System.out.println("hello"+userid);
        Date date=new Date();
        DateFormat formatdatetime = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
        String taketime=formatdatetime.format(date);
        if(checkTake(userid,missionid)) {
            missionDao.passApplicants(userid, missionid, taketime);
            missionDao.deleteApply(missionid);
            missionDao.updateState("已开始",missionid);
           return true;
        }
        return false;
    }




    @PostMapping("getexperiences")
    @CrossOrigin(origins ="*")
    public String getExperiences(@RequestParam(value="message") String message)
    {
        JSONObject json=JSONObject.parseObject(message);
        int userid=Integer.parseInt(json.get("userid").toString());
        int missionid=Integer.parseInt(json.get("missionid").toString());
        System.out.println("hello"+userid);
        return missionDao.getExperience(userid,missionid);
    }




    @PostMapping("getmymissions")
    @CrossOrigin(origins ="*")
    public List<Missions> getMyMissions(@RequestParam(value="message") String message)
    {
        JSONObject json=JSONObject.parseObject(message);
        int publisherid=Integer.parseInt(json.get("publisherid").toString());
        System.out.println("hello"+publisherid);
        return missionDao.findMissionByPublisherid(publisherid);
    }

    @PostMapping("getappliedmissions")
    @CrossOrigin(origins ="*")
    public List<Missions> getAppliedMissions(@RequestParam(value="message") String message)
    {
        JSONObject json=JSONObject.parseObject(message);
        int userid=Integer.parseInt(json.get("userid").toString());
        System.out.println("hello"+userid);
        return missionDao.findMissionsByApplicantid(userid);
    }

    @PostMapping("getcollectedmissions")
    @CrossOrigin(origins ="*")
    public List<Missions> getCollectedMissions(@RequestParam(value="message") String message)
    {
        JSONObject json=JSONObject.parseObject(message);
        int userid=Integer.parseInt(json.get("userid").toString());
        System.out.println("hello"+userid);
        return missionDao.findCollectedMissions(userid);
    }


    @PostMapping("getallmissions")
    @CrossOrigin(origins ="*")
    public List<Missions> getAllMissions(@RequestParam(value="message") String message)
    {
        JSONObject json=JSONObject.parseObject(message);
        System.out.println("hello");
        return missionDao.findAll();
    }


    @PostMapping("getpublishedmissions")
    @CrossOrigin(origins ="*")
    public List<Missions> getPublishedMissions(@RequestParam(value="message") String message)
    {
        JSONObject json=JSONObject.parseObject(message);
        String  phone=json.get("phone").toString();
        List<Missions> list= missionDao.findMissionByPhone(phone);
        return list;
    }
}
