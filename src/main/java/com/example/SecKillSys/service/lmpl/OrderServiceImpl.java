package com.example.SecKillSys.service.lmpl;

import com.example.SecKillSys.enums.Gender;
import com.example.SecKillSys.po.*;
import com.example.SecKillSys.repository.OrderRepository;
import com.example.SecKillSys.service.BuildingService;
import com.example.SecKillSys.service.GroupService;
import com.example.SecKillSys.service.OrderService;
import com.example.SecKillSys.service.RoomService;
import com.example.SecKillSys.util.BaseUtil;
import com.example.SecKillSys.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    GroupService groupService;

    @Autowired
    BuildingService buildingService;

    @Autowired
    RoomService roomService;

    @Override
    public OrderVO process(Integer GroupId, Integer BuildingId) throws Exception {
        GroupVO groupVO = groupService.findGroupById(GroupId);
//        if (groupVO.getStatus()) throw new Exception("该组已经成功完成订单");
        //创建订单
        Order order = new Order(null, GroupId, BuildingId, 0, null);
        orderRepository.save(order);
        return upOrder(groupVO, BuildingId, order);
    }

    @Transactional(rollbackFor = Exception.class)
    public OrderVO upOrder(GroupVO groupVO, Integer BuildingId, Order order) throws Exception {
//        roomService.checkAll();
        BuildingVO buildingVO = buildingService.retrieveBuildingDetails(BuildingId);
        //开始选择房间
        int num = groupVO.getUserVOS().size();
        Gender gender = groupVO.getGender();
        RoomVO selectVO = new RoomVO();
        Boolean selected = false;
        for (RoomVO r : buildingVO.getRooms()) {
            if (gender == r.getGender() && num <= r.getRemainNums()) {
                selectVO = r;
                selected = true;
                break;
            }
        }
        if (!selected) throw new Exception("未选到房间");
        //保存订单信息
        order.setStatus(1);
        order.setRid(selectVO.getId());
        orderRepository.save(order);
        groupService.updateGroupStatus(groupVO.getId());
        //保存房间，床和用户信息
        List<Bed> beds = roomService.findAllEmptyBeds(selectVO.getId());
        for (UserVO u : groupVO.getUserVOS()) {
            for (Bed b : beds) {
                if (b.getStatus() == 0) {
                    b.setStatus(1);
                    b.setSNum(u.getSnum());
                    roomService.updateBed(b);
                    break;
                }
            }
        }
//        selectVO.setRemainNums(selectVO.getRemainNums() - num);
//        Room room = BaseUtil.copyProperties(selectVO, Room.class);
//        room.setBid(BuildingId);
        Room room = roomService.findRoomByID(selectVO.getId());
        room.setRemainNums(room.getRemainNums() - num);
        roomService.updateRoom(room);
//        roomService.check(selectVO.getId());
        //生成返回订单
        OrderVO orderVO = BaseUtil.copyProperties(order, OrderVO.class);
        orderVO.setGroupVO(groupVO);
        return orderVO;
    }
}
