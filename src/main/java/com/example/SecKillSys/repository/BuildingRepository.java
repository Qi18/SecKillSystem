package com.example.SecKillSys.repository;

import com.example.SecKillSys.po.Building;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: rich
 * @date: 2022/10/15 10:18
 * @description:
 */
public interface BuildingRepository extends JpaRepository<Building, Integer> {

    Building findBuildingById(Integer building_id);
}
