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

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<UserVO> findAll() throws Exception {
        List<User> users = userRepository.findAll();
        List<UserVO> userVOS = users.stream().map(r -> {
            try {
                return BaseUtil.copyProperties(r, UserVO.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
        return userVOS;
    }

    @Override
    public UserVO findById(Integer id) throws Exception {
        User user = userRepository.findUserById(id);
        if (user != null) return BaseUtil.copyProperties(user, UserVO.class);
        throw new BusinessException(ReturnCode.NO_SUCH_USER);
    }

    @Override
    public UserVO findByUsername(String username) throws Exception {
        User user = userRepository.findUserByUsername(username);
        if (user != null) return BaseUtil.copyProperties(user, UserVO.class);
        throw new BusinessException(ReturnCode.NO_SUCH_USER);
    }

    @Override
    public UserVO updateUser(UserVO userVO) throws Exception {
        if (userVO.getId() != null) {
            User user = userRepository.findUserById(userVO.getId());
            BaseUtil.copyProperties(userVO, user);
            userRepository.save(user);
        }
        System.out.println(userVO.getId());
        return BaseUtil.copyProperties(userRepository.findUserById(userVO.getId()),UserVO.class);
    }

    @Override
    public void addUser(UserVO userVO) throws Exception {
        User user = BaseUtil.copyProperties(userVO, User.class);
        user.setId(null);
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer id) throws Exception {
        userRepository.deleteById(id);
    }


}
