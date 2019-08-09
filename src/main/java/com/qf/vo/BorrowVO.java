package com.qf.vo;

import lombok.Data;

@Data
public class BorrowVO {


    private String date;
    private Double totalmoney;

    public BorrowVO() {
    }

    public BorrowVO(String date, Double totalmoney) {
        this.date = date;
        this.totalmoney = totalmoney;
    }
}
