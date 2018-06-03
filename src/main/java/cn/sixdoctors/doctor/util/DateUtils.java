package cn.sixdoctors.doctor.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getDateString(Date date) {
        if (date != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(date);
        } else {
            return null;
        }

    }

    public static String getDateString(String date) {
        if (date != null) {
            return date.substring(0, 10);
        } else {
            return null;
        }

    }
}
