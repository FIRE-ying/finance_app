package com.qf.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @program: finance_app2
 * @description: 去除double后的小数点
 * @author: 李显辉
 * @create: 2019/08/08 12:06
 */


public class NumberFormat {

    public static String  format(double d){
        BigDecimal bd=new BigDecimal(d);
        BigDecimal a = bd.setScale(2, RoundingMode.HALF_UP);
        return a.toString();
    }
}
