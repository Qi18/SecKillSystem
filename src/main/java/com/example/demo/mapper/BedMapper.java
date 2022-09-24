package com.example.demo.mapper;

import com.example.demo.dao.Bed;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BedMapper {
    /**
     * 查询所有房间信息
     * @return
     */
    List<Bed> findAll();
}