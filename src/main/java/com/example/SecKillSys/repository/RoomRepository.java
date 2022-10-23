package com.example.SecKillSys.repository;

import com.example.SecKillSys.po.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/16 11:52
 * @description:
 */
public interface RoomRepository extends JpaRepository<Room, Integer> {

    List<Room> findAllByBid(Integer build_id);

    Room findRoomById(Integer room_id);

}
