package com.qf.pojo;

public class Condition {
    private Integer cid;

    private Integer age;

    private String house;

    private String work;

    private Integer houseAge;

    private Double salary;

    private String credit;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house == null ? null : house.trim();
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work == null ? null : work.trim();
    }

    public Integer getHouseAge() {
        return houseAge;
    }

    public void setHouseAge(Integer houseAge) {
        this.houseAge = houseAge;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit == null ? null : credit.trim();
    }
}