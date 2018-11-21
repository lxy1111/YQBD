package com.example.yqbd.Dao;

import com.example.yqbd.entity.Missions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface missionDao extends JpaRepository<Missions,Integer> {


     @Query(value="select * from missions where mission_id=?1",nativeQuery = true)
      List<Missions> findByMissionid(int missionid);

     @Query(value="select * from missions where missionname=?1",nativeQuery = true)
      List<Missions> findByMissionname(String name);

     @Query(value="select * from missions,user where user.user_id = missions.publisherid and user.phone=?1",nativeQuery = true)
     List<Missions> findMissionByPhone(String phone);

     @Query(value="select * from missions where missionname=?1",nativeQuery = true)
    List<Missions> findMissionByMissionname(String missionname);

    @Query(value="select * from missions where publisherid=?1",nativeQuery = true)
    List<Missions> findMissionByPublisherid(int publisherid);

    @Transactional
   @Query(value="insert into apply values(?1,?2,?3,?4,?5)",nativeQuery = true)
   @Modifying
    void applyForMissions(int publisherid,int missionid,String publishtime,String experience,String applyreason);


    @Query(value="select * from missions where publisherid=?1 and mission_id=?2",nativeQuery = true)
    List<Missions> checkIfTheUserIsPublisher(int publisherid,int missionid);

    @Query(value = "select * from apply where user_id=?1 and mission_id=?2",nativeQuery = true)
    List checkApply(int userid, int missionid);

    @Query(value="select missions.* from apply natural join missions where apply.user_id=?1",nativeQuery = true)
    List<Missions> findMissionsByApplicantid(int applicantid);

    @Query(value="select missions.* from collect natural join missions where collect.user_id=?1",nativeQuery = true)
    List<Missions> findCollectedMissions(int userid);

    @Query(value = "select * from take where user_id=?1 and mission_id=?2",nativeQuery = true)
    List checkTake(int userid, int missionid);

    @Transactional
    @Modifying
    @Query(value="insert into collect values(?1,?2,?3)",nativeQuery = true)
    void collectMissions(int userid,int missionid,String collecttime);

    @Transactional
    @Modifying
    @Query(value="update missions set state=?1 where mission_id=?2",nativeQuery = true)
    void updateState(String state,int missionid);

    @Transactional
    @Modifying
    @Query(value="delete from apply where  mission_id=?1",nativeQuery = true)
    void deleteApply(int missionid);

    @Transactional
    @Modifying
    @Query(value="insert into take values(?1,?2,?3)",nativeQuery = true)
    void passApplicants(int userid,int missionid,String taketime);

    @Query(value="select * from collect where user_id=?1 and mission_id=?2",nativeQuery = true)
    List checkCollection(int userid,int missionid);

    @Query(value="select applyreason from apply where user_id=?1 and mission_id=?2",nativeQuery = true)
    String getApplyReason(int userid,int missionid);

    @Query(value="select experience from apply where user_id=?1 and mission_id=?2",nativeQuery = true)
    String getExperience(int userid,int missionid);



}
