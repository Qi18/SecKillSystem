package com.example.SecKillSys.servicelmpl;

import com.example.SecKillSys.po.Building;
import com.example.SecKillSys.po.Room;
import com.example.SecKillSys.repository.BuildingRepository;
import com.example.SecKillSys.repository.RoomRepository;
import com.example.SecKillSys.service.BuildingService;
import com.example.SecKillSys.util.BaseUtil;
import com.example.SecKillSys.vo.BuildingVO;
import com.example.SecKillSys.vo.RoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/16 10:34
 * @description:
 */

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    RoomRepository roomRepository;

    @Override
    public List<BuildingVO> retrieveAllBuildings() throws Exception {
        List<Building> buildings = buildingRepository.findAll();
        System.out.println(buildings);
        List<BuildingVO> result = new ArrayList<>();
        for (Building i : buildings) {
            List<Room> rooms = roomRepository.findAllByBid(i.getId());
            System.out.println(rooms);
            List<RoomVO> roomVOS = new ArrayList<>();
            int sumNums = 0;
            int sumRemainNums = 0;
            for (Room j : rooms) {
                roomVOS.add(BaseUtil.copyProperties(j, RoomVO.class));
                sumNums += j.getNums();
                sumRemainNums += j.getRemainNums();
            }
            BuildingVO buildingVO = BaseUtil.copyProperties(i, BuildingVO.class);
            buildingVO.setNums(sumNums);
            buildingVO.setRemainNums(sumRemainNums);
            buildingVO.setRooms(roomVOS);
            result.add(buildingVO);
        }
        System.out.println(result);
        return result;
    }

    @Override
    public BuildingVO retrieveBuildingDetails(Integer building_id) {
        return null;
    }
}
