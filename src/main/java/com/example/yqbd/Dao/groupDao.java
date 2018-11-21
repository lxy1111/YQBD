package com.example.yqbd.Dao;


import com.example.yqbd.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface groupDao extends JpaRepository<Team,Integer> {

    @Transactional
    @Modifying
    @Query(value="insert into memberof values(?1,?2)",nativeQuery = true)
    void addGroupMembers(String userphone,int groupid);


    @Transactional
    @Modifying
    @Query(value="delete from team where groupid=?1",nativeQuery = true)
    void deletegroup(int groupid);

    @Query(value="select * from team where creatorid=?1",nativeQuery = true)
    List<Team> getMyGroups(int creatorid);

    @Query(value="select team.* from team,memberof where team.groupid=memberof.groupid and userphone=?1",nativeQuery = true)
    List<Team> getJoinedGroups(String userphone);



}
