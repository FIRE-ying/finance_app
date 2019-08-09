package com.qf.vo;

import lombok.Data;

import java.util.List;

@Data
public class HistoryVO {

    private Integer pid;
    private Integer payNumber;
    private Double bmoney;
    private Integer totalNumber;
    private Integer status;
    private String bdate;
    private String appTime;
    private Double totalMoney;

    private List<PayVO> details;
}
