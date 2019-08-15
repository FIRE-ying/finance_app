package com.qf.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: finance_app2
 * @description: 时间转换和计算
 * @author: 李显辉
 * @create: 2019/08/06 21:42
 */
public class DateFormat {

    /***
     * date转calendar
     * @param date
     * @return
     */
    public static Calendar dateToCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println("caldendar==>"+calendar);
        return calendar;
    }

    /**
     * date转caldendar
     * @param calendar
     * @return
     */
    public static  Date calendarToDate(Calendar calendar){
        return calendar.getTime();
    }


    /**
     *
     * @param date
     * @param payNumber  已还的期数
     * @return
     */
    public static Date dayAndMonth(Date date,int payNumber){
        Calendar calendar = dateToCalendar(date);
        int i = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("借款的日期:"+i);
        System.out.println("每月还款的日期+=====>"+day);
        calendar.add(Calendar.MONTH,payNumber+1);
        Date date1 = calendarToDate(calendar);
        System.out.println("下次还款时间:"+date1);
        return date1;

    }



}