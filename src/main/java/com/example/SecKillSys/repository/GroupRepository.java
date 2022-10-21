package com.example.SecKillSys.repository;

import com.example.SecKillSys.po.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author: rich
 * @date: 2022/10/21 20:12
 * @description:
 */
public interface GroupRepository extends JpaRepository<Group, Integer> {


}
