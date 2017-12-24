package xyz.sluggard.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

    private static final String DATETIME_PATTERN = "yyyy-MM-dd hh:mm:ss";

    private static final String DATE_PATTERN = "yyyy-MM-dd";

    private static final String TIME_PATTERN = "hh:mm:ss";

    private static ThreadLocal<SimpleDateFormat> dataTimeFormat = new ThreadLocal<SimpleDateFormat>(){

        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DATETIME_PATTERN);
        }
    };

    private static ThreadLocal<SimpleDateFormat> dataFormat = new ThreadLocal<SimpleDateFormat>(){

        @Override
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DATE_PATTERN);
        }
    };

    private static ThreadLocal<SimpleDateFormat> timeFormat = new ThreadLocal<SimpleDateFormat>(){

        @Override
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(TIME_PATTERN);
        }
    };

    public static Date dateTimeParse(String source) throws ParseException {
        return dataTimeFormat.get().parse(source);
    }

    public static String dateTimeFormat(Date date) {
        return dataTimeFormat.get().format(date);
    }

    public static Date dateParse(String source) throws ParseException {
        return dataFormat.get().parse(source);
    }

    public static String dateFormat(Date date) {
        return dataFormat.get().format(date);
    }

    public static Date timeParse(String source) throws ParseException {
        return timeFormat.get().parse(source);
    }

    public static String timeFormat(Date date) {
        return timeFormat.get().format(date);
    }


}
