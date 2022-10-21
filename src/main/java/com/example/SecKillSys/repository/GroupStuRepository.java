package com.example.SecKillSys.repository;

import com.example.SecKillSys.po.GroupStu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/21 19:38
 * @description:
 */
public interface GroupStuRepository extends JpaRepository<GroupStu, Integer> {

    @Query(value = "select * from Group_Stu gs where gs.group_id = ?1", nativeQuery = true)
    List<GroupStu> findAllByGroupId(Integer group_id);
}
