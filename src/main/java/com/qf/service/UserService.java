package com.qf.service;

import com.qf.pojo.User;

/**
 * 生活很好，记得微笑🙂
 */

public interface UserService {
    User selectuser(String phone);

    User selectByUserNameOrPhone(String loginName);

    User selectByLoginName(String userName,String password);


}
