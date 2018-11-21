package com.example.yqbd.Dao;

import com.example.yqbd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface userDao extends JpaRepository<User,Integer> {

    @Query(value="select * from  user where user_id=?1",nativeQuery = true)
    User findByUser_id(int user_id);

    @Query(value="select * from user where realname=?1",nativeQuery = true)
    List<User> findByRealname(String realname);

    @Query(value="select * from user where corporation=?1",nativeQuery = true)
    List<User> findByCorporation(String corporation);

    @Query(value="select user.* from apply natural join  user natural join missions where mission_id=?1",nativeQuery = true)
    List<User> findAllApplicantsOfMission(int missionid);

    @Query(value="select * from user where phone=?1 and password=?2",nativeQuery = true)
    User findByPhoneAndPassword(String phone,String password);

    @Query(value="select * from user where phone=?1",nativeQuery = true)
    List<User> checkIfUserExists(String phone);

    @Transactional
    @Modifying
    @Query(value="insert into contact values(?1,?2)",nativeQuery = true)
    void addContact(int myid,String phone);


    @Transactional
    @Modifying
    @Query(value="insert into group values(?1,?2,?3,?4)",nativeQuery = true)
    void createGroup(int groupid ,String groupname,int creatorid,String createdtime);

    @Query(value="select * from contacts,user where contacts.friendphone=user.phone and contacts.myid=?1",nativeQuery = true)
    List<User> getMyContacts(int myid);


    @Query(value="select * from user where phone = ?1",nativeQuery = true)
    List<User> checkMemberofGroup(String phone);

    @Query(value="select user.* from team,memberof,user where team.groupid=memberof.groupid and memberof.userphone=user.phone and team.groupid=?1",nativeQuery = true)
    List<User> getMemberofGroup(int groupid);









}
