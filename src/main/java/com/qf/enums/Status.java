package com.qf.enums;

public enum Status {
    NO_CHECK(1,"未审核"),
    CHECKING(2,"审核中"),
    WAIT_MONEY(3,"等待放款"),
    PAYING(4,"还款中"),
    PAID(5,"已还清");


    private Integer code;
    private String type;

    Status(Integer code, String type) {
        this.code = code;
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
