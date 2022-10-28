package com.example.SecKillSys.controller;

import com.example.SecKillSys.response.AjaxResult;
import com.example.SecKillSys.service.BuildingService;
import com.example.SecKillSys.vo.BuildingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/16 15:31
 * @description:
 */

@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    BuildingService buildingService;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public AjaxResult findAll() throws Exception {
        AjaxResult ajax = AjaxResult.success();
        List<BuildingVO> buildingList = buildingService.retrieveAllBuildings();
        ajax.put(AjaxResult.DATA_TAG, buildingList);
        return ajax;
    }

    @RequestMapping(value = "{buildingId}/detail", method = RequestMethod.GET)
    public AjaxResult retrieveBuildingDetail(@PathVariable Integer buildingId) throws Exception {
        AjaxResult ajax = AjaxResult.success();
        BuildingVO buildingVO = buildingService.retrieveBuildingDetails(buildingId);
        ajax.put(AjaxResult.DATA_TAG, buildingVO);
        return ajax;
    }
}
