package com.example.SecKillSys.service;

import com.example.SecKillSys.po.Building;
import com.example.SecKillSys.po.Group;
import com.example.SecKillSys.po.Order;
import com.example.SecKillSys.po.User;
import com.example.SecKillSys.vo.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/21 19:39
 * @description:
 */
public interface OrderService {


    /*
     * @param orderVO:
     * @return: com.example.SecKillSys.po.Order
     * @author: rich
     * @date: 2022/10/21 20:03
     * @description: 提交订单，返回订单（状态），成功后应该修改bed，room
     */
    OrderVO upOrder(Integer GroupId, Integer BuildId) throws Exception;

}
