package com.example.SecKillSys.servicelmpl;

import com.example.SecKillSys.enums.ReturnCode;
import com.example.SecKillSys.enums.UserType;
import com.example.SecKillSys.exception.BusinessException;
import com.example.SecKillSys.po.User;
import com.example.SecKillSys.repository.BuildingRepository;
import com.example.SecKillSys.repository.UserRepository;
import com.example.SecKillSys.util.BaseUtil;
import com.example.SecKillSys.vo.UserVO;
import com.example.SecKillSys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Override
    public UserVO findByUsername(String username) throws Exception {
        User user = userRepository.findUserByUsername(username);
        if (user != null) return BaseUtil.copyProperties(user, UserVO.class);
        throw new BusinessException(ReturnCode.NO_SUCH_USER);
    }

    @Override
    public UserVO update(UserVO userVO) throws Exception {
        if (userVO.getId() != null) userRepository.save((User) Objects.requireNonNull(BaseUtil.copyProperties(userVO, User.class)));
        System.out.println(userVO.getId());
        return BaseUtil.copyProperties(userRepository.findUserById(userVO.getId()),UserVO.class);
    }
}
