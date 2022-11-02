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


    OrderVO process(Integer GroupId, Integer BuildingId) throws Exception;



}
