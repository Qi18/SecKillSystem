package com.example.demo.controller;


import com.example.demo.dao.Bed;
import com.example.demo.mapper.BedMapper;
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
