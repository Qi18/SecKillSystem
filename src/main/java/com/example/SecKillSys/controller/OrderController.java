package com.example.SecKillSys.controller;

import com.example.SecKillSys.service.GroupService;
import com.example.SecKillSys.service.OrderService;
import com.example.SecKillSys.vo.GroupStuVO;
import com.example.SecKillSys.vo.GroupVO;
import com.example.SecKillSys.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    GroupService groupService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "createGroup", method = RequestMethod.POST)
    public GroupVO createGroup(@RequestBody List<GroupStuVO> groupStuVOs) throws Exception {
        return groupService.createGroup(groupStuVOs);
    }

    @RequestMapping(value = "preOrder", method = RequestMethod.POST)
    public OrderVO preOrder(@RequestParam("groupId")Integer groupId, @RequestParam("buildId")Integer buildId) throws Exception {
        return orderService.upOrder(groupId, buildId);
    }
}
