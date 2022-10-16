package com.example.SecKillSys.repository;

import com.example.SecKillSys.po.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/16 10:29
 * @description:
 */
public interface BuildingRepository extends JpaRepository<Building, Integer> {

    List<Building> findAll();

    Building findBuildingById(Integer id);

}
