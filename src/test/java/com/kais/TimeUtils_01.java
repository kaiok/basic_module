package com.kais;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author kais
 * @date 2022.09.23. 15:19
 */
public class TimeUtils_01 {

    public static void main(String[] args) throws ParseException {

        System.out.println(TimeUtils_01.setDayNumber("30","2022-09-01"));

    }
    public static String setDayNumber(String number,String date) throws ParseException {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(date);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(parse);
        calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)+ Integer.parseInt(number)) ;
        String remindTime =sdf.format(calendar.getTime());
        System.out.println(remindTime);
        return remindTime;

    }

}
