package com.example.SecKillSys.service.lmpl;

import com.example.SecKillSys.exception.BusinessException;
import com.example.SecKillSys.po.Group;
import com.example.SecKillSys.po.GroupStu;
import com.example.SecKillSys.po.Order;
import com.example.SecKillSys.po.User;
import com.example.SecKillSys.repository.GroupRepository;
import com.example.SecKillSys.repository.GroupStuRepository;
import com.example.SecKillSys.repository.OrderRepository;
import com.example.SecKillSys.service.OrderService;
import com.example.SecKillSys.util.BaseUtil;
import com.example.SecKillSys.vo.BuildingVO;
import com.example.SecKillSys.vo.GroupVO;
import com.example.SecKillSys.vo.OrderVO;
import com.example.SecKillSys.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public GroupVO createGroup(List<UserVO> userVOS) throws Exception {
        if (userVOS == null || userVOS.size() == 0) throw new Exception("未传入有效信息");
        List<User> users = userVOS.stream().map(r -> {
            try {
                return BaseUtil.copyProperties(r, User.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
        Group group = new Group(null, users.get(0).getGender(), null);
        for (User i : users) {
            if (i.getGender() != group.getGender()) throw new Exception("所选同伴的性别不合适");
        }
        group = groupRepository.save(group);
        System.out.println(group);
        for (User i : users) {
            groupStuRepository.save(new GroupStu(null, group.getId(), i.getSNum()));
        }
        return BaseUtil.copyProperties(group, );
    }

    @Override
    public OrderVO createOrder(GroupVO group, BuildingVO building) {
        return null;
    }

    @Override
    public Order upOrder(OrderVO orderVO) {
        return null;
    }
}
