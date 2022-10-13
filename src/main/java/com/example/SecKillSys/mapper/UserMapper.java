package com.example.SecKillSys.mapper;

import com.example.SecKillSys.po.Bed;
import com.example.SecKillSys.po.BuildingAdmin;
import com.example.SecKillSys.po.StuAdmin;
import com.example.SecKillSys.po.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {


     Student getStuByUsername(String username, String password);

     BuildingAdmin getBAByUsername(String username, String password);

     StuAdmin getSAByUsername(String username, String password);

}