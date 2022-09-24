package com.example.SecKillSys.controller;


import com.example.SecKillSys.dao.Bed;
import com.example.SecKillSys.mapper.BedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class BedController {

    @Autowired
    BedMapper bedMapper;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Bed> ListUser(){
        return bedMapper.findAll();
    }

}
