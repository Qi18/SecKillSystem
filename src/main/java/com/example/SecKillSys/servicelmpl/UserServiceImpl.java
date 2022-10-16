package com.example.SecKillSys.servicelmpl;

import com.example.SecKillSys.enums.ReturnCode;
import com.example.SecKillSys.enums.UserType;
import com.example.SecKillSys.exception.BusinessException;
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

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BuildingAdminRepository buildingAdminRepository;

    @Autowired
    StuAdminRepository stuAdminRepository;

    @Override
    public UserVO findByUsername(String username) throws Exception {
        Student student = studentRepository.findStudentByUsername(username);
        if (student != null) return BaseUtil.changeToUser(student);
        BuildingAdmin buildingAdmin = buildingAdminRepository.findBuildingAdminByUsername(username);
        if (buildingAdmin != null) return BaseUtil.changeToUser(buildingAdmin);
        StuAdmin stuAdmin = stuAdminRepository.findStuAdminByUsername(username);
        if (stuAdmin != null) return BaseUtil.changeToUser(stuAdmin);
        throw new BusinessException(ReturnCode.NO_SUCH_USER);
    }

    @Override
    public UserVO update(UserVO userVO) throws Exception {
        if (userVO.getUserType() == UserType.Student) {
            studentRepository.save((Student) Objects.requireNonNull(BaseUtil.changeToPo(userVO)));
            return BaseUtil.changeToUser(studentRepository.findById(userVO.getId()).get());
        }
        else if (userVO.getUserType() == UserType.Student_Admin) {
            stuAdminRepository.save((StuAdmin) Objects.requireNonNull(BaseUtil.changeToPo(userVO)));
            return BaseUtil.changeToUser(stuAdminRepository.findById(userVO.getId()).get());
        }
        else if (userVO.getUserType() == UserType.Building_Admin) {
            buildingAdminRepository.save((BuildingAdmin) Objects.requireNonNull(BaseUtil.changeToPo(userVO)));
            return BaseUtil.changeToUser(buildingAdminRepository.findById(userVO.getId()).get());
        }
        throw new BusinessException(ReturnCode.RC500);
    }
}
