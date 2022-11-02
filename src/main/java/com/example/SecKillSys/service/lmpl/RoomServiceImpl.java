package com.example.SecKillSys.service.lmpl;

import com.example.SecKillSys.po.Bed;
import com.example.SecKillSys.po.Room;
import com.example.SecKillSys.repository.BedRepository;
import com.example.SecKillSys.repository.RoomRepository;
import com.example.SecKillSys.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Room findRoomByID(Integer roomId) {
        return roomRepository.findRoomById(roomId);
    }

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

    @Transactional
    @Override
    public void check(Integer roomId) {
        Room room = roomRepository.findRoomById(roomId);
        List<Bed> beds = bedRepository.findAllByRid(roomId);
        List<Bed> emptyBeds = bedRepository.findAllEmptyByRid(roomId);
        if (room.getNums() != beds.size()) {
            room.setNums(beds.size());
            roomRepository.save(room);
        }
        if (room.getRemainNums() != emptyBeds.size()) {
            room.setRemainNums(emptyBeds.size());
            roomRepository.save(room);
        }
    }

    @Transactional
    @Override
    public void checkAll() {
        List<Room> rooms = roomRepository.findAll();
        for (Room r : rooms) {
            List<Bed> beds = bedRepository.findAllByRid(r.getId());
            List<Bed> emptyBeds = bedRepository.findAllEmptyByRid(r.getId());
            if (r.getNums() != beds.size()) {
                r.setNums(beds.size());
                roomRepository.save(r);
                System.out.println("修改nums为" + beds.size());
            }
            if (r.getRemainNums() != emptyBeds.size()) {
                r.setRemainNums(emptyBeds.size());
                roomRepository.save(r);
                System.out.println("修改renums为" + emptyBeds.size());
            }
        }
    }

}
