package com.qf.pojo;

public class Product {
    private Integer pid;

    private Double drate;

    private Double monrate;

    private Double yrate;

    private Double overrate;

    private String loanAmout;

    private String payDate;

    private Integer cid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Double getDrate() {
        return drate;
    }

    public void setDrate(Double drate) {
        this.drate = drate;
    }

    public Double getMonrate() {
        return monrate;
    }

    public void setMonrate(Double monrate) {
        this.monrate = monrate;
    }

    public Double getYrate() {
        return yrate;
    }

    public void setYrate(Double yrate) {
        this.yrate = yrate;
    }

    public Double getOverrate() {
        return overrate;
    }

    public void setOverrate(Double overrate) {
        this.overrate = overrate;
    }

    public String getLoanAmout() {
        return loanAmout;
    }

    public void setLoanAmout(String loanAmout) {
        this.loanAmout = loanAmout == null ? null : loanAmout.trim();
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate == null ? null : payDate.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}