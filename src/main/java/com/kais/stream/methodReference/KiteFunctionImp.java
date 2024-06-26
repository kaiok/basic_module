package com.kais.stream.methodReference;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author kais
 * @date 2022.07.01. 14:22
 */
public class KiteFunctionImp implements KiteFunction<LocalDateTime,String,String>{

    @Override
    public String run(LocalDateTime dateTime, String s) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(s);
        return dateTime.format(dateTimeFormatter);
    }
}
