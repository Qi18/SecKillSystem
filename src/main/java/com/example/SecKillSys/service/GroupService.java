package com.example.SecKillSys.service;

import com.example.SecKillSys.vo.GroupStuVO;
import com.example.SecKillSys.vo.GroupVO;

import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/23 14:12
 * @description:
 */
public interface GroupService {

    GroupVO createGroup(List<GroupStuVO> groupStuVOs) throws Exception;

    GroupVO findGroupById(Integer id) throws Exception;

    void updateGroupStatus(Integer group_id) throws Exception;
}
