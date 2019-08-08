package com.qf.web;

import com.qf.pojo.Borrow;
import com.qf.pojo.User;
import com.qf.service.BorrowMapperService;
import com.qf.service.SmsService;
import com.qf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 生活很好，记得微笑🙂
 */
@RestController
public class BorrowController {

    @Resource
    private BorrowMapperService borrowMapperService;
    @Resource
    private UserService userService;
    @Resource
    private SmsService smsService;

    /**
     * 获取验证码
     * @param phone
     * @param session
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value ="/finance/getyanpass")
    public Map getyanpass(String phone, HttpSession session){

        int num = smsService.single_sendTest(phone);
        session.setAttribute("num",num);
        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","成功");
        map.put("data",num);
        System.out.println(num);
        return map;
    }

    /*@RequestMapping(method = RequestMethod.GET,value ="/a")
    public String a(String num,HttpSession session){
        session.setAttribute("num",num);

        return "ok";
    }*/

    /**
     * 验证码登陆
     * @param phone
     * @param num
     * @param session
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value ="/finance/yanlogin")
    public Map yanlogin(String phone,String num,HttpSession session){
        Map map=new HashMap();
        String num1 = (String) session.getAttribute("num");
        User user = userService.selectuser(phone);
        if (user==null){
            map.put("code",1);
            map.put("msg","失败");
            map.put("data",null);
        }
        else {
            if (num.equals(num1)){
                map.put("code",0);
                map.put("msg","成功");
                map.put("data",user);

            }else {
                map.put("code",1);
                map.put("msg","失败");
                map.put("data","验证码错误");
            }
        }
        return map;
    }

    /**
     * 查询贷款用户信息
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value ="/finance/getclient")
    public Map findallborrow(){

        List<Borrow> list = borrowMapperService.findallborrow();
        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","成功");
        map.put("data",list);
        return map;
    }
    /**
     * 申请贷款
     */
    @RequestMapping(method = RequestMethod.POST,value ="/finance/addfinance")
    public Map addfinance(Borrow borrow){
        borrow.setStatus(1);           //未审核
        borrow.setBdate(new Date());   //申请时间
        borrow.setPayNumber(0);      //还款次数
        //borrow.setPid(1);            //产品id
        int i = borrowMapperService.insertSelective(borrow);
        System.out.println("申请贷款----"+i);
        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","成功");
        map.put("data",null);
        return map;
    }

}
