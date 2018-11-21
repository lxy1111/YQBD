package com.example.yqbd.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.yqbd.Dao.userDao;
import com.example.yqbd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    private userDao userDao;



    @PostMapping("addcontacts")
    @CrossOrigin(origins ="*")
    public boolean addContacts(@RequestParam(value="message") String message) {
        JSONObject user=JSONObject.parseObject(message);
        int myid=Integer.parseInt(user.get("myid").toString());
        String friendphone=user.get("friendphone").toString();
        userDao.addContact(myid,friendphone);
        return true;
    }

    @PostMapping("getcontacts")
    @CrossOrigin(origins ="*")
    public List<User> getMyContacts(@RequestParam(value="message") String message)
    {
        JSONObject user=JSONObject.parseObject(message);
        int myid=Integer.parseInt(user.get("myid").toString());
        return userDao.getMyContacts(myid);
    }






    @PostMapping("register")
    @CrossOrigin(origins ="*")
    public boolean addUser(@RequestParam(value="message") String message){
        JSONObject user=JSONObject.parseObject(message);
        String phone=user.get("phone").toString();
        String pwd=user.get("password").toString();
        String name=user.get("name").toString();
        String gender=user.get("gender").toString();
        int age=Integer.parseInt(user.get("age").toString());
        String corporation=user.get("corporation").toString();
        String job=user.get("job").toString();
        String address=user.get("address").toString();
        List<User> list=userDao.checkIfUserExists(phone);
        if(list.size()>0) {
            return false;
        }
        else {
            User newuser = new User();
            newuser.setPhone(phone);
            newuser.setPassword(pwd);
            newuser.setRealname(name);
            newuser.setAge(age);
            newuser.setCorporation(corporation);
            newuser.setGender(gender);
            newuser.setUser_address(address);
            newuser.setJob(job);
            newuser.setTitle("普通用户");
            userDao.save(newuser);
            return true;
        }
    }

    @PostMapping("getmembersofgroup")
    @CrossOrigin(origins = "*")
    public List<User> getMembersOfGroup(@RequestParam(value="message") String message){
        JSONObject json =JSONObject.parseObject(message);
        int groupid=Integer.parseInt(json.get("groupid").toString());
        System.out.println(groupid);
        return userDao.getMemberofGroup(groupid);
    }


    @PostMapping("/login")
    @CrossOrigin(origins ="*")
    public User loginUser(@RequestParam(value="message") String message)throws JSONException
    {
        JSONObject user=JSONObject.parseObject(message);
        String phone=user.get("phone").toString();
        String pwd=user.get("pwd").toString();
        System.out.println(phone);
        System.out.println(pwd);
       User finduser=userDao.findByPhoneAndPassword(phone,pwd);
       if(finduser!=null)
       {
           return finduser;
       }
           return null;
    }



}
