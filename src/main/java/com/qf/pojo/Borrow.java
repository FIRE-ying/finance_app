package com.qf.pojo;

import java.util.Date;

public class Borrow {
    private Integer bid;

    private Integer uid;

    private Integer pid;

    private Integer payNumber;

    private Integer totleNumber;

    private Date bdate;

    private String jname;

    private String jsex;

    private Date jdate;

    private String jcard;

    private String profession;

    private String address;

    private Double bmoney;

    private String creditCard;

    private Integer status;

    private Date appTime;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPayNumber() {
        return payNumber;
    }

    public void setPayNumber(Integer payNumber) {
        this.payNumber = payNumber;
    }

    public Integer getTotleNumber() {
        return totleNumber;
    }

    public void setTotleNumber(Integer totleNumber) {
        this.totleNumber = totleNumber;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname == null ? null : jname.trim();
    }

    public String getJsex() {
        return jsex;
    }

    public void setJsex(String jsex) {
        this.jsex = jsex == null ? null : jsex.trim();
    }

    public Date getJdate() {
        return jdate;
    }

    public void setJdate(Date jdate) {
        this.jdate = jdate;
    }

    public String getJcard() {
        return jcard;
    }

    public void setJcard(String jcard) {
        this.jcard = jcard == null ? null : jcard.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Double getBmoney() {
        return bmoney;
    }

    public void setBmoney(Double bmoney) {
        this.bmoney = bmoney;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard == null ? null : creditCard.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAppTime() {
        return appTime;
    }

    public void setAppTime(Date appTime) {
        this.appTime = appTime;
    }
}