package com.qf.service;

import com.qf.pojo.User;

/**
 * 生活很好，记得微笑🙂
 */

public interface UserService {
    User selectuser(String phone);
    int insertUser(User user);

    User selectByPrimaryKey(Integer userid);
}
