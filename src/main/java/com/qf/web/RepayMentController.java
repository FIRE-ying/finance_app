package com.qf.web;

import com.qf.service.RepayService;
import com.qf.utils.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.ws.rs.PUT;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: finance_app2
 * @description: 处理还款的controller
 * @author: 李显辉
 * @create: 2019/08/06 20:00
 */


@Controller
public class RepayMentController {

    @Resource
    private RepayService service;

    @RequestMapping(value = "/repayment/list",method = RequestMethod.POST)  //
    @ResponseBody
    public Map  repaylist(String userid){
        List<ResponseMessage> list = service.findbyuid(userid);
        Map map=null;
        if (list!=null&&list.size()>0){
            map=new HashMap();
            map.put("code",0);
            map.put("msg","成功");
            map.put("data",list);

            return map;
        }else {
            map=new HashMap();
            map.put("code",1);
            map.put("msg","失败");
            map.put("data","");
            return map;
        }
    }


    @RequestMapping(value = "/repayment/paymoney",method = RequestMethod.POST)
    @ResponseBody
    public Map  payed(int bid,String password){
        System.out.println(bid+"--->"+password);
        Map<String, String> map = service.payed(bid, password);
        Map remap=new HashMap();
        if (map!=null&&map.size()>0){
            remap.put("code","0");
            remap.put("msg","成功");
            remap.put("data",map);
        }else {
            remap.put("code","1");
            remap.put("msg","失败");
            remap.put("data",null);
        }

        return remap;
    }





}
