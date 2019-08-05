package com.qf.web;

import com.qf.pojo.Borrow;
import com.qf.service.BorrowMapperService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生活很好，记得微笑🙂
 */
@Controller
public class BorrowController {

    @Resource
    private BorrowMapperService borrowMapperService;

    /**
     * 查询贷款用户信息
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value ="/finance/getclient")
    @ResponseBody
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
    @ResponseBody
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
