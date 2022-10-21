package com.example.SecKillSys.repository;

import com.example.SecKillSys.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
     
     User findStudentByUsername(String username);

     User findStudentByUsernameAndPassword(String username, String password);

     List<User> findAll();

}