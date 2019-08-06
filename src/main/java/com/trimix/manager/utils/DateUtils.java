package com.trimix.manager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static java.sql.Date convertToSqlDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed;
        java.sql.Date sql = null;
        try {
            parsed = format.parse(date);
            sql = new java.sql.Date(parsed.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sql;
    }
}
