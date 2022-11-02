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

    Room findRoomByID(Integer roomId);

    List<Bed> findAllEmptyBeds(Integer roomId);

    void updateBed(Bed bed) throws Exception;

    void updateRoom(Room room) throws Exception;

    /*
     * @return: java.lang.Boolean
     * @author: rich
     * @date: 2022/10/23 15:33
     * @description: 验证房间和床位的有效性,修改房间床位数量信息
     */
    void check(Integer roomId);

    void checkAll();
}
