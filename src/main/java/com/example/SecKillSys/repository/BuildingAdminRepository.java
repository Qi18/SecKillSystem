package com.example.SecKillSys.repository;

import com.example.SecKillSys.po.BuildingAdmin;
import com.example.SecKillSys.po.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: rich
 * @date: 2022/10/15 10:18
 * @description:
 */
public interface BuildingAdminRepository extends JpaRepository<BuildingAdmin, Integer> {

    BuildingAdmin findBuildingAdminByUsernameAndPassword(String username, String password);

    BuildingAdmin findBuildingAdminByUsername(String username);
}
