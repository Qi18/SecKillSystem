package com.example.SecKillSys.repository;

import com.example.SecKillSys.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

     User findUserById(Integer id);

     User findUserByUsername(String username);

     User findUserByUsernameAndPassword(String username, String password);

     @Query(value = "select * from Users", nativeQuery = true)
     List<User> findAll();

     @Modifying
     @Transactional
     @Query(value = "delete from Users u where u.id = :id", nativeQuery = true)
     void deleteById(@Param(value = "id") Integer id);

}