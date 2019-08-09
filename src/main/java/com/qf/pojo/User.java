package com.qf.pojo;

import java.util.Date;

public class User {
    private Integer userid;

    private String realname;

    private String password;

    private String phone;

    private String myimg;

    private String idcaid;

    private String username;

    private String profession;

    private String address;

    private String spass;

    private Date logintime;

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMyimg() {
        return myimg;
    }

    public void setMyimg(String myimg) {
        this.myimg = myimg == null ? null : myimg.trim();
    }

    public String getIdcaid() {
        return idcaid;
    }

    public void setIdcaid(String idcaid) {
        this.idcaid = idcaid == null ? null : idcaid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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

    public String getSpass() {
        return spass;
    }

    public void setSpass(String spass) {
        this.spass = spass == null ? null : spass.trim();
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }


}