package cn.sixdoctors.doctor.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getDateString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static String getDateString(String date) {
        return date.substring(0, 10);
    }
}
