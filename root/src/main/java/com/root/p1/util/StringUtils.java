package com.root.p1.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

    /**
     * Convert Date to String by format
     * @param date
     * @param format
     * @return String
     */
    public static String convertDateToStringByFormat(Date date, String format) throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
}
