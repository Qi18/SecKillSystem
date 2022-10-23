package com.example.SecKillSys.service;

import com.example.SecKillSys.po.Bed;
import com.example.SecKillSys.po.Room;

import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/16 11:59
 * @description:
 */
public interface RoomService {

    List<Bed> findAllEmptyBeds(Integer roomId);

    void updateBed(Bed bed) throws Exception;

    void updateRoom(Room room) throws Exception;
}
