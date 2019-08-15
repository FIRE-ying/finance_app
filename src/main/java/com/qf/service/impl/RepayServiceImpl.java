package com.qf.service.impl;

import com.qf.mapper.BorrowMapper;
import com.qf.mapper.ProductMapper;
import com.qf.mapper.UserMapper;
import com.qf.pojo.Borrow;
import com.qf.pojo.Product;
import com.qf.pojo.User;
import com.qf.service.ProductService;
import com.qf.service.RepayService;
import com.qf.utils.DateFormat;
import com.qf.utils.NumberFormat;
import com.qf.utils.ResponseMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @program: finance_app2
 * @description: 根据uid查询借款service
 * @author: 李显辉
 * @create: 2019/08/06 20:09
 */
@Service
public class RepayServiceImpl implements RepayService {
    @Resource
    private BorrowMapper borrowMapper;
    @Resource
    private ProductMapper productMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public List<ResponseMessage> findbyuid(String uid) {
        List<Borrow> list = borrowMapper.findbyuid(uid);
        List<ResponseMessage> datalist=new ArrayList<>();
        for (Borrow borrow : list) {
            ResponseMessage data=new ResponseMessage();
            data.setBid(borrow.getBid());
            //已还的期数
            Integer payNumber = borrow.getPayNumber();
            data.setPayid(payNumber);
            //总的期数
            Integer totleNumber = borrow.getTotleNumber();
            data.setPays(totleNumber);
            //总的贷款金额
            Double bmoney = borrow.getBmoney();
            //本金*月利率/总期数
            Product product = productMapper.selectByPrimaryKey( borrow.getPid());
            Double monrate = product.getMonrate();
            double v = bmoney *(monrate+1)/ totleNumber;
            data.setPmoney(NumberFormat.format(v));
            //全部代还金额
            double v1 = bmoney * (monrate + 1) * (1 - payNumber / totleNumber);
            data.setTotlemoney(v1);
            //还款日期
            Date appTime = borrow.getAppTime();
            Date date = DateFormat.dayAndMonth(appTime, payNumber);
               data.setDate(date);
            System.out.println(data);
            datalist.add(data);
        }
        return datalist ;
    }


    @Override
    @Transactional
    public Map<String, String> payed(Integer bid, String password) {
        Map<String,String> map=new HashMap<>();
        Borrow borrow = borrowMapper.selectByPrimaryKey(bid);
        Integer uid = borrow.getUid();
        User user = userMapper.selectByPrimaryKey(uid);
        String spass = user.getSpass();
        System.out.println("spass==="+spass);
        if (password.equals(spass)){
            borrowMapper.updateborrowbybid(bid);
            Date appTime = borrow.getAppTime();
            //已还期数
            Integer payNumber = borrow.getPayNumber()+1;
            if (payNumber<borrow.getTotleNumber()){
                Date date = DateFormat.dayAndMonth(appTime, payNumber + 1);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
                //下次还款时间
                String format = simpleDateFormat.format(date);
                map.put("date",format);
            }else {
                map.put("data","已结清");
            }
        }
        return map;
    }
}
