package com.example.SecKillSys.service.lmpl;

import com.example.SecKillSys.enums.Gender;
import com.example.SecKillSys.po.Group;
import com.example.SecKillSys.po.GroupStu;
import com.example.SecKillSys.po.User;
import com.example.SecKillSys.repository.GroupRepository;
import com.example.SecKillSys.repository.GroupStuRepository;
import com.example.SecKillSys.repository.UserRepository;
import com.example.SecKillSys.service.GroupService;
import com.example.SecKillSys.util.BaseUtil;
import com.example.SecKillSys.vo.GroupStuVO;
import com.example.SecKillSys.vo.GroupVO;
import com.example.SecKillSys.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: rich
 * @date: 2022/10/23 14:12
 * @description:
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    GroupStuRepository groupStuRepository;

    @Override
    @Transactional
    public GroupVO createGroup(List<GroupStuVO> groupStuVOs) throws Exception {
        if (groupStuVOs == null || groupStuVOs.size() == 0) throw new Exception("未传入有效信息");
        List<User> users = new ArrayList<>();
        Gender standard = userRepository.findUserBySnum(groupStuVOs.get(0).getSnum()).getGender();
        for (GroupStuVO i : groupStuVOs) {
            User user = userRepository.findUserBySnum(i.getSnum());
            if (user == null) throw new Exception("此学号不存在");
            if (!user.getName().equals(i.getName())) throw new Exception("输入队友信息不正确");
            if (!user.getGender().equals(standard)) throw new Exception("所选同伴的性别不合适");
            users.add(user);
        }
        Group group = new Group(null, standard, null);
        groupRepository.save(group);
        group.setName("第" + group.getId() +"组");
        groupRepository.save(group);
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
    @Transactional
    public GroupVO findGroupById(Integer id) throws Exception {
        if (id == null) throw new Exception("组号不存在");
        GroupVO groupVO = BaseUtil.copyProperties(groupRepository.findGroupById(id),GroupVO.class);
        List<GroupStu> groupStuList = groupStuRepository.findAllByGroupId(groupVO.getId());
        List<User> users = userRepository.findAllBySnum(groupStuList.stream().map(GroupStu::getSNum).collect(Collectors.toList()));
        List<UserVO> userVOList = new ArrayList<>();
        for (User user : users){
            userVOList.add(BaseUtil.copyProperties(user, UserVO.class));
        }
        groupVO.setUserVOS(userVOList);
        return groupVO;
    }


}
