package com.example.SecKillSys.service;

import com.example.SecKillSys.po.Building;
import com.example.SecKillSys.vo.BuildingVO;

import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/16 10:33
 * @description:
 */
public interface BuildingService {

    List<BuildingVO> retrieveAllBuildings() throws Exception;

    BuildingVO retrieveBuildingDetails(Integer building_id) throws Exception;
}
