package com.wenjie.web.converter;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class StringtoDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        Date date = new Date();
        /*忘怎么写了*/
        return date;
    }
}
