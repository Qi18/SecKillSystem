package com.example.SecKillSys.servicelmpl;

import com.example.SecKillSys.repository.BuildingAdminRepository;
import com.example.SecKillSys.repository.StuAdminRepository;
import com.example.SecKillSys.repository.StudentRepository;
import com.example.SecKillSys.po.BuildingAdmin;
import com.example.SecKillSys.po.StuAdmin;
import com.example.SecKillSys.po.Student;
import com.example.SecKillSys.util.BaseUtil;
import com.example.SecKillSys.vo.UserVO;
import com.example.SecKillSys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BuildingAdminRepository buildingAdminRepository;

    @Autowired
    StuAdminRepository stuAdminRepository;

    /*
     * @param username:
     * @param password: 
     * @return: com.example.SecKillSys.vo.UserVO
     * @author: rich
     * @date: 2022/10/15 12:24
     * @description:
     */
    @Override
    public UserVO login(String username, String password) throws Exception {
        Student student = studentRepository.findStudentByUsernameAndPassword(username, password);
        if (student != null) return BaseUtil.changeToUser(student);
        BuildingAdmin buildingAdmin = buildingAdminRepository.findBuildingAdminByUsernameAndPassword(username, password);
        if (buildingAdmin != null) return BaseUtil.changeToUser(buildingAdmin);
        StuAdmin stuAdmin = stuAdminRepository.findStuAdminByUsernameAndPassword(username, password);
        if (stuAdmin != null) return BaseUtil.changeToUser(stuAdmin);

        //TODO
        //登录未成功，没有此账户，
        return null;
    }
}
