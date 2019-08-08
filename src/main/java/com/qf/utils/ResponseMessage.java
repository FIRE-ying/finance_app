package com.qf.utils;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @program: finance_app2
 * @description: data----->作为返回json的对象
 * @author: 李显辉
 * @create: 2019/08/06 19:41
 */
public class ResponseMessage {

   private int bid;
   private int payid;
   private int pays;
   private String pmoney;
   private double totlemoney;
    @JsonFormat(pattern = "yyyy-MM-dd")
   private Date date;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getPayid() {
        return payid;
    }

    public void setPayid(int payid) {
        this.payid = payid;
    }

    public int getPays() {
        return pays;
    }

    public void setPays(int pays) {
        this.pays = pays;
    }

    public String getPmoney() {
        return pmoney;
    }

    public void setPmoney(String pmoney) {
        this.pmoney = pmoney;
    }

    public double getTotlemoney() {
        return totlemoney;
    }

    public void setTotlemoney(double totlemoney) {
        this.totlemoney = totlemoney;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "bid=" + bid +
                ", payid=" + payid +
                ", pays=" + pays +
                ", pmoney=" + pmoney +
                ", totlemoney=" + totlemoney +
                ", date=" + date +
                '}';
    }
}
