package com.example.SecKillSys.service;

import com.example.SecKillSys.po.Building;
import com.example.SecKillSys.po.Group;
import com.example.SecKillSys.po.Order;
import com.example.SecKillSys.po.User;
import com.example.SecKillSys.vo.BuildingVO;
import com.example.SecKillSys.vo.GroupVO;
import com.example.SecKillSys.vo.OrderVO;
import com.example.SecKillSys.vo.UserVO;

import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/21 19:39
 * @description:
 */
public interface OrderService {

    /*
     * @param userVOS: 用户列表，必须保证是学生
     * @return: java.lang.Boolean
     * @author: rich
     * @date: 2022/10/21 19:53
     * @description: 添加group表，groupStu表
     */
    Group createGroup(List<UserVO> userVOS) throws Exception;

    /*
     * @param group:
     * @param building:
     * @return: com.example.SecKillSys.po.Order
     * @author: rich
     * @date: 2022/10/21 20:02
     * @description: 创建订单
     */
    OrderVO createOrder(GroupVO group, BuildingVO building);

    /*
     * @param orderVO:
     * @return: com.example.SecKillSys.po.Order
     * @author: rich
     * @date: 2022/10/21 20:03
     * @description: 提交订单，返回订单（状态），成功后应该修改bed，room
     */
    Order upOrder(OrderVO orderVO);

}
