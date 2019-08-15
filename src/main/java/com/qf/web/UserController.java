package com.qf.web;

import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.utils.DateFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: finance_app
 * @description: 登录功能
 * @author: 李显辉
 * @create: 2019/08/08 18:02
 */

@RestController
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/finance/beforelogin")
    public  boolean beforeLogin(@RequestParam("username") String loginname){
        User user = userService.selectByUserNameOrPhone(loginname);
        return user==null?false:true;
    }


    @RequestMapping(value = "/finance/login",method = RequestMethod.POST)
    public Map tologin(String username,String password){
        User user = userService.selectByLoginName(username, password);
        Map map=new HashMap();
        if (user!=null){
            map.put("code",0);
            map.put("msg","成功");
            Map map1=new HashMap();
            map1.put("rname",user.getRole().getRname());
            map1.put("username",user.getUsername());
            map1.put("realname",user.getRealname());
            map1.put("password",user.getPassword());
            map1.put("spass",user.getSpass());
            map1.put("myimg",user.getMyimg());
           // map1.put("logintime", DateFormat.localdateformdate(LocalDate.now()));
            map.put("data",map1);
            return map;
        }else {
            map.put("code",1);
            map.put("msg","失败");
            map.put("data",null);
            return map;
        }
    }



    
    
    
     @RequestMapping(method = RequestMethod.POST,value = "finance/confirmusers")
    public Map confirmusers(int userid,String phone) {
        User user = userService.findbyid(userid);
        System.err.println(user.getPhone());
        System.err.println(phone);
        Map map=new HashMap();
        if (phone.equals(user.getPhone())){
            map.put("code",0);
            map.put("msg","成功");
            map.put("data",user);
        }else{
            map.put("code",1);
            map.put("msg","失败");
            map.put("data",null);
        }
        return map;
    }
    @RequestMapping("finance/updatepass")
    public Map updatepass(int userid,String newpass){
        User user = userService.findbyid(userid);
        int i = userService.updateuser(userid,newpass);
        Map map=new HashMap();
        if (i>0){
            map.put("code",0);
            map.put("msg","成功");
            map.put("data",user);
        }else {
            map.put("code",1);
            map.put("msg","失败");
            map.put("data",null);
        }
        return map;
    }
    @RequestMapping("/finance/spass")
    public Map spass(int userid,String spass){
        User user = userService.findbyid(userid);
        Map map=new HashMap();
        if (user.getSpass().equals(spass)){
            map.put("code",0);
            map.put("msg","成功");
            map.put("data",user);
        }else {
            map.put("code",1);
            map.put("msg","失败");
            map.put("data",null);
        }
        return map;
    }
}
