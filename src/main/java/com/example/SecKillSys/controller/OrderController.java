package com.example.SecKillSys.controller;

import com.alibaba.fastjson.JSON;
import com.example.SecKillSys.po.Message;
import com.example.SecKillSys.rabbitmq.MQSender;
import com.example.SecKillSys.response.AjaxResult;
import com.example.SecKillSys.service.GroupService;
import com.example.SecKillSys.service.OrderService;
import com.example.SecKillSys.service.RoomService;
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

    @Autowired
    RoomService roomService;

    @Autowired
    MQSender mqSender;

    @RequestMapping(value = "createGroup", method = RequestMethod.POST)
    public AjaxResult createGroup(@RequestBody List<GroupStuVO> groupStuVOs) throws Exception {
        AjaxResult ajax = AjaxResult.success();
        ajax.put(AjaxResult.DATA_TAG, groupService.createGroup(groupStuVOs));
        roomService.checkAll();
        return ajax;
    }

    @RequestMapping(value = "preOrder", method = RequestMethod.POST)
    public AjaxResult preOrder(@RequestParam("groupId")Integer groupId, @RequestParam("buildId")Integer buildId) throws Exception {
        AjaxResult ajax = AjaxResult.success();
//        ajax.put(AjaxResult.DATA_TAG, orderService.process(groupId, buildId));
        Message message = new Message(groupId, buildId);
        mqSender.sendMessage(message);
        return ajax;
    }
}
