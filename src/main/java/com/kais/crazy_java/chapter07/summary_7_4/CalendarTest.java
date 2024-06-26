package com.kais.crazy_java.chapter07.summary_7_4;

import lombok.var;

import java.util.Calendar;

import static java.util.Calendar.*;

/**
 * @author kais
 * @date 2022.08.18. 16:25
 */
public class CalendarTest {
    public static void main(String[] args) {
        var c = Calendar.getInstance();
        // 取出年
        System.out.println(c.get(YEAR));
        // 取出月份
        System.out.println(c.get(MONTH));
        // 取出日
        System.out.println(c.get(DATE));

        // 分别设置年、月、日、小时、分钟、秒
        c.set(2003, 10, 23, 12, 32, 23); //2003-11-23 12:32:23
        System.out.println("自定义的时间：" + c.getTime());

        // 将Calendar的年前推1年
        c.add(YEAR, -1); //2002-11-23 12:32:23
        System.out.println("自定义时间前一年：" + c.getTime());

        // 将Calendar的月前推8个月
        c.roll(MONTH, -8); //2002-03-23 12:32:23
        System.out.println("自定义时间前8个月：" + c.getTime());

        var cal1 = Calendar.getInstance();
        cal1.set(2003, 7, 23, 0, 0, 0); // 2003-8-23
        System.out.println("自定义的时间（2）：" + cal1.getTime());
        cal1.add(MONTH, 6); //2003-8-23 => 2004-2-23
        System.out.println("自定义时间（2）6个月之后(明年2月)：" + cal1.getTime());

        var cal2 = Calendar.getInstance();
        cal2.set(2003, 7, 31, 0, 0, 0); // 2003-8-31
        // 因为进位到后月份改为2月，2月没有31日，自动变成29日
        cal2.add(MONTH, 6); // 2003-8-31 => 2004-2-29
        System.out.println(cal2.getTime());

        var cal3 = Calendar.getInstance();
        cal3.set(2003, 7, 23, 0, 0, 0); //2003-8-23
        // MONTH字段“进位”，但YEAR字段并不增加
        cal3.roll(MONTH, 6); //2003-8-23 => 2003-2-23
        System.out.println("cal3 = " + cal3.getTime());

        var cal4 = Calendar.getInstance();
        cal4.set(2003, 7, 31, 0, 0, 0); //2003-8-31
        // MONTH字段“进位”后变成2，2月没有31日，
        // YEAR字段不会改变，2003年2月只有28天
        cal4.roll(MONTH, 6); //2003-8-31 => 2003-2-28
        System.out.println(cal4.getTime());
    }
}
