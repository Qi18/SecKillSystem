package com.example.SecKillSys.mapper;

import com.example.SecKillSys.po.Bed;
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