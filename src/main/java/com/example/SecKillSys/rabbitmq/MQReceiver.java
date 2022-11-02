package com.example.SecKillSys.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.example.SecKillSys.po.Message;
import com.example.SecKillSys.service.OrderService;
import com.example.SecKillSys.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: rich
 * @date: 2022/11/2 16:12
 * @description:
 */
@Service
@Slf4j
public class MQReceiver {

    @Autowired
    OrderService orderService;

    @RabbitListener(queues = "Queue")
    public void receive(Message message) throws Exception {
        log.info("接收的消息" + message);
//        Message secKillMessage = JSON.parseObject(message, Message.class);
        Integer buildId = message.getBuildID();
        Integer groupId = message.getGroupID();
        orderService.process(groupId, buildId);
    }
}
