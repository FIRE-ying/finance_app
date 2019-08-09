package com.qf.web;

import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.utils.DataView;
import com.qf.utils.KuaY;
import com.qf.vo.UserVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController extends KuaY {

    @Resource
    private UserService userService;

    /**
     * 注册
     * @param username   用户名
     * @param phone    用户电话
     * @param password     用户密码
     * @param repass    重复密码
     * @return
     */
    @PostMapping("/user/register")
    public DataView insertUser(String username, String phone, String password, String repass){

        System.out.println(username+"--"+password+"--"+phone);
        DataView dataView = null;
        if (repass.equals(password)) {
            User user = new User();
            user.setUsername(username);
            user.setPhone(phone);
            user.setPassword(password);
            int i = userService.insertUser(user);
            if (i > 0) {
                UserVO userVO = new UserVO(username,password,phone);
                dataView = new DataView(0,"成功",userVO);
            } else {
                dataView = new DataView(1,"失败",null);
            }
        }
        return dataView;
    }

}
