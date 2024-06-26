package com.kais;

import java.util.Calendar;

/**
 * @author kais
 * @date 2022.09.23. 13:52
 取当前时间到月底的秒数
 */
public class TimeUtils {

    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        // 当前时间到凌晨12点秒数
        // 本月剩下天数包含的秒数:(cal.getActualMaximum(Calendar.DAY_OF_MONTH) - cal.get(Calendar.DAY_OF_MONTH)) * 24 * 60 * 60)

        System.out.println(((long) (cal.getActualMaximum(Calendar.DAY_OF_MONTH) - cal.get(Calendar.DAY_OF_MONTH)) * 24 * 60 * 60) );

    }

}
