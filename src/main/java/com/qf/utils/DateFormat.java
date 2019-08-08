package com.qf.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @program: finance_app2
 * @description: 时间转换和计算
 * @author: 李显辉
 * @create: 2019/08/06 21:42
 */
public class DateFormat {

    /**
     * date----->localdate
     * @param date
     * @return
     */
    public  static LocalDate  fateformat(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        System.out.println("locadate--->"+localDate);
        return localDate;
    }

   /* ZoneId zone = ZoneId.systemDefault();
    Instant instant = localDateTime.atZone(zone).toInstant();
    java.util.Date date = Date.from(instant);*/

   public static Date localdateformdate(LocalDate localDate){
       ZoneId zone = ZoneId.systemDefault();
       Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
   }


    /**
     *逾期时间
     * @param localDate 上次还款日期
     * @return
     */
    public static int getDays(LocalDate localDate){
        //现在日期
        LocalDate date=LocalDate.now();
        int days = localDate.until(date).getDays();
        System.out.println("days---->");
        return days;
    }

    /**
     * 还款日期  ---->指定每个月的那天还款
     * @param localDate 审核时间
     * @param
     * @return
     */
    public static  LocalDate getLocalDate(LocalDate  localDate){
        int day = localDate.getDayOfMonth();
        return LocalDate.now().withDayOfMonth(day);
    }

    /***
     * 根据审核时间和已还的期数计算下次还款的时间
     * @param localDate
     * @param number 已还期数
     * @return
     */
    public static  LocalDate getLocalDate2(LocalDate  localDate,int number){
        int moneth = localDate.getMonthValue() + number + 1;
        LocalDate date2=null;
        if (moneth<12){
           date2 = LocalDate.of(localDate.getYear(),moneth , localDate.getDayOfMonth());
        }else {
            date2 = LocalDate.of(localDate.getYear(),moneth-12 , localDate.getDayOfMonth());
        }

        return date2;
    }



}
