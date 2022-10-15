package com.example.SecKillSys.repository;

import com.example.SecKillSys.po.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
     
     Student findStudentByUsername(String username);

     Student findStudentByUsernameAndPassword(String username, String password);

     List<Student> findAll();

}