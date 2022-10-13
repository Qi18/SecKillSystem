package com.example.SecKillSys.servicelmpl;

import com.example.SecKillSys.enums.UserType;
import com.example.SecKillSys.mapper.UserMapper;
import com.example.SecKillSys.po.BuildingAdmin;
import com.example.SecKillSys.po.StuAdmin;
import com.example.SecKillSys.po.Student;
import com.example.SecKillSys.util.BaseUtil;
import com.example.SecKillSys.vo.UserVO;
import com.example.SecKillSys.service.UserService;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserVO login(String username, String password)  {
        Student student = userMapper.getStuByUsername(username, password);
        if (student != null) return BaseUtil.changeToUser(student);
        BuildingAdmin buildingAdmin = userMapper.getBAByUsername(username, password);
        if (buildingAdmin != null) return BaseUtil.changeToUser(buildingAdmin);
        StuAdmin stuAdmin = userMapper.getSAByUsername(username, password);
        if (stuAdmin != null) return BaseUtil.changeToUser(stuAdmin);

        //TODO
        //登录未成功，没有此账户，
        return null;
    }
}
