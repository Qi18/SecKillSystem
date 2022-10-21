package com.example.SecKillSys.service.lmpl;

import com.example.SecKillSys.po.Bed;
import com.example.SecKillSys.po.Building;
import com.example.SecKillSys.po.Room;
import com.example.SecKillSys.repository.BedRepository;
import com.example.SecKillSys.repository.BuildingRepository;
import com.example.SecKillSys.repository.RoomRepository;
import com.example.SecKillSys.service.BuildingService;
import com.example.SecKillSys.util.BaseUtil;
import com.example.SecKillSys.vo.BedVO;
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

    @Autowired
    BedRepository bedRepository;

    @Override
    public List<BuildingVO> retrieveAllBuildings() throws Exception {
        List<Building> buildings = buildingRepository.findAll();
        List<BuildingVO> result = new ArrayList<>();
        for (Building i : buildings) {
            List<Room> rooms = roomRepository.findAllByBid(i.getId());
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
        return result;
    }

    @Override
    public BuildingVO retrieveBuildingDetails(Integer building_id) throws Exception {
        Building building = buildingRepository.findBuildingById(building_id);
        BuildingVO buildingVO = BaseUtil.copyProperties(building, BuildingVO.class);
        List<Room> rooms = roomRepository.findAllByBid(building_id);
        List<RoomVO> roomVOS = new ArrayList<>();
        int sumNums = 0;
        int sumRemainNums = 0;
        for (Room i : rooms) {
            List<Bed> beds = bedRepository.findAllByRid(i.getId());
            List<BedVO> bedVOS = new ArrayList<>();
            for (Bed j : beds) {
                bedVOS.add(BaseUtil.copyProperties(j, BedVO.class));
            }
            RoomVO roomVO = BaseUtil.copyProperties(i, RoomVO.class);
            roomVO.setBeds(bedVOS);
            roomVOS.add(roomVO);
            sumNums += i.getNums();
            sumRemainNums += i.getRemainNums();
        }
        buildingVO.setNums(sumNums);
        buildingVO.setRemainNums(sumRemainNums);
        buildingVO.setRooms(roomVOS);
        return buildingVO;
    }
}
