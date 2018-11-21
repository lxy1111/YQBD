package com.example.yqbd.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.yqbd.Dao.groupDao;
import com.example.yqbd.Dao.userDao;
import com.example.yqbd.entity.Team;
import com.example.yqbd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/group")
public class groupController {

    @Autowired
    private groupDao groupDao;

    @Autowired
    private userDao userDao;


    @PostMapping("getapplicants")
    @CrossOrigin(origins = "*")
    public List<User> getApplicants(@RequestParam(value="message") String message){
        JSONObject user=JSONObject.parseObject(message);
        int missionid=Integer.parseInt(user.get("missionid").toString());
        List<User> list = userDao.findAllApplicantsOfMission(missionid);
        System.out.println(list.size());
        return list;
    }

    @PostMapping("creategroup")
    @CrossOrigin(origins = "*")
    public boolean createGroups(@RequestParam(value="message") String message){
        JSONObject group=JSONObject.parseObject(message);
        String introducton=group.get("groupintroduction").toString();
        String groupname=group.get("groupname").toString();
        int creatorid=Integer.parseInt(group.get("creatorid").toString());
        System.out.println(introducton+" "+groupname+" "+creatorid);
        Date date=new Date();
        DateFormat formatdatetime = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
        String createdtime=formatdatetime.format(date);
        System.out.println(createdtime);
        Team newgroup=new Team();
        newgroup.setIntroduction(introducton);
        newgroup.setGroupname(groupname);
        newgroup.setCreatorid(creatorid);
        newgroup.setCreatedtime(createdtime);
        groupDao.save(newgroup);
        return true;
    }

    @PostMapping("deletegroup")
    @CrossOrigin(origins = "*")
    public boolean deleteGroups(@RequestParam(value="message") String message){
        JSONObject group=JSONObject.parseObject(message);
        int groupid=Integer.parseInt(group.get("groupid").toString());
        groupDao.deletegroup(groupid);
        return true;
    }

    @PostMapping("getallmygroups")
    @CrossOrigin(origins = "*")
    public List<Team> getAllMyGroup(@RequestParam(value="message") String message){
        JSONObject json =JSONObject.parseObject(message);
        int userid=Integer.parseInt(json.get("userid").toString());
        return groupDao.getMyGroups(userid);
    }


    @PostMapping("getjoinedgroups")
    @CrossOrigin(origins = "*")
    public List<Team> getJoinedGroups(@RequestParam(value="message") String message){
        JSONObject json =JSONObject.parseObject(message);
        String userphone=json.get("userphone").toString();
        return groupDao.getJoinedGroups(userphone);
    }


    public boolean checkNewMember(String memberphone)
    {
        List<User> list=userDao.checkMemberofGroup(memberphone);

      if(list.size()>0) {
          return true;
      }
      return false;
    }




    @PostMapping("addnewmemberofgroup")
    @CrossOrigin(origins = "*")
    public boolean addNewMember(@RequestParam(value="message") String message){
        JSONObject json =JSONObject.parseObject(message);
        String userphone=json.get("userphone").toString();
        System.out.println(userphone);
        if(checkNewMember(userphone)) {
            int groupid = Integer.parseInt(json.get("groupid").toString());
            groupDao.addGroupMembers(userphone, groupid);
            return true;
        }
        return false;
    }




}
