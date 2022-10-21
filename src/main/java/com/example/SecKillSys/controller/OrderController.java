package com.example.SecKillSys.controller;

import com.example.SecKillSys.service.OrderService;
import com.example.SecKillSys.vo.GroupStuVO;
import com.example.SecKillSys.vo.GroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/21 20:07
 * @description:
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "createGroup", method = RequestMethod.POST)
    public GroupVO createGroup(@RequestBody List<GroupStuVO> groupStuVOs) throws Exception {
        return orderService.createGroup(groupStuVOs);
    }
}
