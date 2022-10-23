package com.example.SecKillSys.service.lmpl;

import com.example.SecKillSys.po.Bed;
import com.example.SecKillSys.po.Room;
import com.example.SecKillSys.repository.BedRepository;
import com.example.SecKillSys.repository.RoomRepository;
import com.example.SecKillSys.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/16 11:59
 * @description:
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    BedRepository bedRepository;

    @Override
    public List<Bed> findAllEmptyBeds(Integer roomId) {
        return bedRepository.findAllEmptyByRid(roomId);
    }

    @Override
    public void updateBed(Bed bed) throws Exception {
        if (bed.getId() != null) bedRepository.save(bed);
        else throw new Exception("床位信息错误");
    }

    @Override
    public void updateRoom(Room room) throws Exception {
        if (room.getId() != null) roomRepository.save(room);
        else throw new Exception("房间信息错误");
    }
}
