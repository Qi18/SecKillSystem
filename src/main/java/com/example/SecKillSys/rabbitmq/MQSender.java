package com.example.SecKillSys.rabbitmq;

import com.example.SecKillSys.po.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: rich
 * @date: 2022/11/2 16:13
 * @description:
 */
@Service
@Slf4j
public class MQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Message message) {
        log.info("发送信息:" + message);
        rabbitTemplate.convertAndSend("Exchange", "seckill.message",message);
    }
}
