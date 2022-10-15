package com.example.SecKillSys.repository;

import com.example.SecKillSys.po.StuAdmin;
import com.example.SecKillSys.po.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: rich
 * @date: 2022/10/15 10:19
 * @description:
 */
public interface StuAdminRepository extends JpaRepository<StuAdmin, Integer>  {

    StuAdmin findStuAdminByUsernameAndPassword(String username, String password);
}
