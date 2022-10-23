package com.example.SecKillSys.repository;

import com.example.SecKillSys.enums.Gender;
import com.example.SecKillSys.po.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

/**
 * @author: rich
 * @date: 2022/10/21 20:12
 * @description:
 */
public interface GroupRepository extends JpaRepository<Group, Integer> {

//    @Modifying
//    @Transactional
//    @Query(value = "insert into Group (gender, name) values (:#{#group.gender},:#{#group.name})",nativeQuery = true)
//    void insertByGroup(Group group);

//    @Modifying
//    @Transactional
//    @Query(value = "INSERT into Groups (gender, name) values (?1, ?2)",nativeQuery = true)
//    void insertByGenderAndName(Gender gender, String name);
}
