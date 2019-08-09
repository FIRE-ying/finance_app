package com.qf.web;

import com.qf.common.Product;
import com.qf.pojo.Borrow;
import com.qf.pojo.User;
import com.qf.service.BorrowMapperService;
import com.qf.service.SmsService;
import com.qf.service.UserService;
import com.qf.utils.DataView;
import com.qf.vo.BorrowVO;
import com.qf.vo.HistoryVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
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
        System.out.println(num);
        return map;
    }

    /*@RequestMapping(method = RequestMethod.GET,value ="/a")
    public String a(String num,HttpSession session){
        session.setAttribute("num",num);

        return "ok";
    }
    */

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

  /*  *//**
     * 支付确认
     * @param bid
     * @param spass    手势密码
     * @return
     *//*
    @PostMapping("/repayment/paymoney")
    public DataView payMoney(int bid, String spass){
        DataView dataView = null;
        Borrow borrow = borrowMapperService.selectByPrimaryKey(bid);
        String s = userService.selectByPrimaryKey(borrow.getUid()).getSpass();
        if (spass.equals(s)){
            int i = borrowMapperService.repayment(bid);
            if (i>0){
                BorrowVO borrowVO = new BorrowVO();
                Date bdate = borrow.getBdate();
                bdate.setMonth(bdate.getMonth()+1);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                String format = simpleDateFormat.format(bdate);
                borrowVO.setDate(format);
                borrowVO.setTotalmoney(borrow.getBmoney()*Math.pow(borrow.getTotleNumber(), Product.monrate));
                dataView = new DataView(0,"成功",borrowVO);
            }else {
                dataView = new DataView(1,"失败",null);
            }
        }
        return dataView;
    }
*/
    /**
     * 根据状态查历史交易记录
     * @param uid    当前用户id
     * @param status    当前还款状态
     * @return
     */
    @PostMapping("/repayment/history")
    public HistoryVO findHistory(@Param("uid") int uid, @Param("status") int status){
        return borrowMapperService.findByStatus(uid, status);
    }

}
