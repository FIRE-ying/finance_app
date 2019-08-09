package com.qf.service.impl;

import com.qf.mapper.UserMapper;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 生活很好，记得微笑🙂
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User selectuser(String phone) {
        return userMapper.selectuser(phone);
    }

    @Override
    public User selectByUserNameOrPhone(String loginName) {
        return userMapper.selectByusernameOrPhone(loginName);
    }

    @Override
    public User selectByLoginName(String userName, String password) {

        User user = userMapper.selectByusernameOrPhone(userName);
        if (user != null) {
            if (password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }
}
