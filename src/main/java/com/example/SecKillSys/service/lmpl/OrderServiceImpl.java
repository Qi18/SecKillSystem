package com.example.SecKillSys.service.lmpl;

import com.example.SecKillSys.po.Group;
import com.example.SecKillSys.po.GroupStu;
import com.example.SecKillSys.po.Order;
import com.example.SecKillSys.po.User;
import com.example.SecKillSys.repository.GroupRepository;
import com.example.SecKillSys.repository.GroupStuRepository;
import com.example.SecKillSys.repository.OrderRepository;
import com.example.SecKillSys.repository.UserRepository;
import com.example.SecKillSys.service.OrderService;
import com.example.SecKillSys.util.BaseUtil;
import com.example.SecKillSys.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: rich
 * @date: 2022/10/21 19:44
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    GroupStuRepository groupStuRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public GroupVO createGroup(List<GroupStuVO> groupStuVOs) throws Exception {
        if (groupStuVOs == null || groupStuVOs.size() == 0) throw new Exception("未传入有效信息");
        List<User> users = groupStuVOs.stream().map(r -> {
            User user = userRepository.findUserBySnum(r.getSnum());
            if (!user.getName().equals(r.getName())) try {
                throw new Exception("输入队友信息不正确");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;
        }).collect(Collectors.toList());
        Group group = new Group(null, users.get(0).getGender(), "1");
        System.out.println(group);
        for (User i : users) {
            if (i.getGender() != group.getGender()) throw new Exception("所选同伴的性别不合适");
        }
        group = groupRepository.save(group);
        System.out.println(group);
        for (User i : users) {
            groupStuRepository.save(new GroupStu(null, group.getId(), i.getSnum()));
        }
        List<GroupStu> groupStus = groupStuRepository.findAllByGroupId(group.getId());
        GroupVO groupVO = BaseUtil.copyProperties(group, GroupVO.class);
        groupVO.setUserVOS(users.stream().map(r -> {
            try {
                return BaseUtil.copyProperties(r, UserVO.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList()));
        return groupVO;
    }

    @Override
    public OrderVO createOrder(GroupVO group, BuildingVO building) {
        return null;
    }

    @Override
    public OrderVO upOrder(OrderVO orderVO) {
        return null;
    }
}
