package com.panda.english.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author baipf
 * @version V1.0
 * @Title: DateUtils.java
 * @Package com.tniu.juexing.util
 * @Description: 日期工具类整理
 * @date 2017年1月3日 上午9:01:56
 */
public class DateUtils {
    // =============================================

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    /**
     * 日期格式yyyy-MM-dd字符串常量
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 日期格式yyyyMMdd字符串常量
     */
    public static final String DATE_FORMAT_yyyyMMdd = "yyyyMMdd";

    /**
     * 日期格式HH:mm:ss字符串常量
     */
    private static final String HOUR_FORMAT = "HH:mm:ss";
    /**
     * 日期格式yyyy-MM-dd HH:mm:ss字符串常量
     */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String DATETIME_MINUTE = "yyyy-MM-dd HH:mm";

    private static final String DATETIME_FORMAT3 = "yyyy/MM/dd HH:mm";

    private static final String DATETIME_FORMAT_YEAR_MONTH_DAY = "yyyy年MM月dd日 HH:mm";

    private static final String DATETIME_FORMAT_MONTH_DAY = "MM月dd日";

    private static final SimpleDateFormat HHmm_FORMAT3 = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat sdf_date_format = new SimpleDateFormat(DATE_FORMAT);

    private static SimpleDateFormat sdf_date_formatyyyyMMdd = new SimpleDateFormat(DATE_FORMAT_yyyyMMdd);

    private static SimpleDateFormat sdf_hour_format = new SimpleDateFormat(HOUR_FORMAT);
    private static SimpleDateFormat sdf_datetime_format = new SimpleDateFormat(DATETIME_FORMAT);

    private static SimpleDateFormat sdf_datetime_minute = new SimpleDateFormat(DATETIME_MINUTE);

    private static SimpleDateFormat sdf_datetime_format3 = new SimpleDateFormat(DATETIME_FORMAT3);

    private static SimpleDateFormat sdf_datetime_format4 = new SimpleDateFormat("yyyyMMddHHmm");

    private static SimpleDateFormat sdf_datetime_format5 = new SimpleDateFormat(DATETIME_FORMAT_YEAR_MONTH_DAY);

    private static SimpleDateFormat sdf_datetime_format6 = new SimpleDateFormat(DATETIME_FORMAT_MONTH_DAY);
    private static SimpleDateFormat sdf_datetime_format7 = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdf_datetime_format8 = new SimpleDateFormat("HH:mm");

    private final static long MINUTE = 60;
    private final static long HOUR = 60 * MINUTE;
    private final static long DAY = 24 * HOUR;
    private final static long MONTH = 31 * DAY;
    private final static long YEAR = 12 * MONTH;


    private static String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    // ~ Methods
    // ================================================================


    public static String getWeekOfDate(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public static Date formatStrToDate(String dateStr) {
        Date date = new Date();
        try {
            date = sdf_datetime_format5.parse(dateStr);

        } catch (ParseException e) {
            logger.error("String字符串解析成date错误:{}", dateStr);
        }
        return date;
    }

    /**
     * date ; yyyy-MM-dd HH:mm:ss
     *
     * @param iDate
     * @return
     */
    public static Date getDateFromInteger(Integer iDate) {
        return new Date(iDate);
    }

    /**
     * 时间戳转date
     *
     * @param timeStamp
     * @return
     */
    public static Date getDateFromTimeStamp(int timeStamp) {
        return new Date(timeStamp * 1000L);
    }

    public static Date getLong2Date(Long time) {
        return new Date(time);
    }

    /**
     * 获取指定时间String 表示 07/23 14:59
     *
     * @param date
     * @return
     */
    public static String getDateDesp(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        if (Calendar.getInstance().get(Calendar.YEAR) == year) {
            //今年
            return turnStr(day) + "/" + turnStr(month) + " " + turnStr(hour) + ":" + turnStr(minute);
        }

        return turnStr(day) + "/" + turnStr(month) + "/" + year + " " + turnStr(hour) + ":" + turnStr(minute);
    }

    /**
     * 获取月日,如 4月20日
     *
     * @param date
     * @return
     */
    public static String getYdDesp(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return month + "月" + turnStr(day) + "日";
    }

    /**
     * 获取期数描述
     *
     * @return
     */
    public static String getGameNoDesp(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String desp = "";
        if (hour < 12) {
            desp = "上午场";
        } else {
            desp = "下午场";
        }

        return year + "-" + month + "-" + day + " " + desp;

    }

    /**
     * 获取指定时间String 表示 yyyyMMdd
     *
     * @param date
     * @return
     */
    public static String getDateStr(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return year + "" + turnStr(month) + turnStr(day);
    }

    private static String turnStr(int num) {
        if (num < 10) {
            return "0" + num;
        }

        return num + "";
    }


    /**
     * 获取当前小时 24小时制
     * @return 获取当前小时 根据时间参数
     */
    public static int getHoursByDate(Date date){
        if (date == null){
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * date str yyyyMMdd;
     *
     * @param dateStr
     * @return
     */
    public static int getUnitimeFromStringyyyyMMdd(String dateStr) {
        Date date = null;
        long num = 0L;
        try {
            date = sdf_date_formatyyyyMMdd.parse(dateStr);
            num = date.getTime() / 1000;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return (int) num;
    }

    /**
     * date str yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr
     * @return
     */
    public static int getFromStringyyyyMMddHHmmss(String dateStr) {
        Date date = null;
        long num = 0L;
        try {
            date = sdf_datetime_format.parse(dateStr);
            num = date.getTime() / 1000;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (int) num;
    }

    /**
     * date str yyyy-MM-dd
     *
     * @param dateStr
     * @return
     */
    public static int getFromStringyyyyMMdd(String dateStr) {
        Date date = null;
        long num = 0L;
        try {
            date = sdf_date_format.parse(dateStr);
            num = date.getTime() / 1000;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (int) num;
    }

    public static Date getFromStringyyyyMMdd2Date(String dateStr) {
        Date date = null;
        long num = 0L;
        try {
            date = sdf_date_format.parse(dateStr);
            return date;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return date;
    }

    public static String getHHmm() {
        return HHmm_FORMAT3.format(new Date());
    }

    public static String getHHmm(int unixTime) {
        return HHmm_FORMAT3.format(new Date(unixTime * 1000L));
    }

    public static String getHHmm(Date date) {
        return HHmm_FORMAT3.format(date);
    }

    public static String getyyyyMMddHHmm(int unixTime) {
        return sdf_datetime_minute.format(new Date(unixTime * 1000L));
    }

    /**
     * date str yyyy-MM-dd HH:mm
     *
     * @param dateStr
     * @return
     */
    public static int getFromStringyyyyMMddHHmm(String dateStr) {
        Date date = null;
        long num = 0L;
        try {
            date = sdf_datetime_minute.parse(dateStr);
            num = date.getTime() / 1000;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (int) num;
    }

    /**
     * 将 yyyy-MM-dd 字符串转换为 日期格式
     *
     * @param dateStr
     * @return
     */
    public static Date getDateYMD(String dateStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (Exception e) {
            logger.error("字符串转date出错", e);
        }
        return date;
    }

    /**
     * 将 yyyy-MM-dd HH:mm:ss 字符串转换为 日期格式
     *
     * @param dateStr
     * @return
     */
    public static Date getDateYmdhms(String dateStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMAT);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (Exception e) {
            logger.error("字符串转date出错", e);
        }
        return date;
    }

    /**
     * 字符串转换为 日期格式
     *
     * @param dateStr
     * @return
     */
    public static Date getDateYmdhms(String dateStr, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (Exception e) {
            logger.error("字符串转date出错", e);
        }
        return date;
    }

//    /**
//     * 比较是否是同一天
//     *
//     * @param date
//     * @param date2
//     * @return
//     */
//    public static boolean compareDay(Date date, Date date2) {
//        Date specDate = getSpecDate(date, Calendar.DATE);
//        Date specDate1 = getSpecDate(date2, Calendar.DATE);
//        return specDate.getTime() == specDate1.getTime();
//    }

    /**
     * 获取 yyyy-MM-dd 时间字符串
     *
     * @param date
     * @return
     */
    public static String getYmdStr(Date date) {
        Calendar calendar = Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);
        calendar.setTime(date);
        /*if (nowYear == calendar.get(Calendar.YEAR)){
            return formatStr(calendar.get(Calendar.MONTH)+1)+"-"+formatStr(calendar.get(Calendar.DATE));
        }*/
        return calendar.get(Calendar.YEAR) + "-" + formatStr(calendar.get(Calendar.MONTH) + 1) + "-" + formatStr(calendar.get(Calendar.DATE));
    }

    /**
     * 获取 HH:mm
     *
     * @param date
     * @return
     */
    public static String getHmsStr(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return formatStr(calendar.get(Calendar.HOUR_OF_DAY)) + ":" + formatStr(calendar.get(Calendar.MINUTE));
    }

    private static String formatStr(int num) {
        if (num < 10) {
            return "0" + num;
        }
        return "" + num;
    }

    /**
     * 获取日期描述 2017-12-31 -> 2017年报
     * 2017-06-30 -> 2017中报
     * 2017-03-31 -> 2017一季报
     * 2017-09-30 -> 2017三季报
     *
     * @param date yyyy-MM-dd 格式
     * @return
     */
    public static String getDateDesp(String date) {
        Date dateYMD = getDateYMD(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateYMD);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        String desp = "";
        switch (month) {
            case Calendar.DECEMBER:
                desp = "年报";
                break;
            case Calendar.JUNE:
                desp = "中报";
                break;
            case Calendar.MARCH:
                desp = "一季报";
                break;
            case Calendar.SEPTEMBER:
                desp = "三季报";
                break;
        }
        return year + desp;
    }

    public static long getLongUnixTime() {
        return System.currentTimeMillis() / 1000;
    }

    public static long getLongUnixTimeByDate(Date date) {
        return date.getTime() / 1000;

    }

    public static boolean compare24hours(long unixtime) {
        long between = unixtime - getLongUnixTime();
        return between >= 24 * 3600;
    }

    public static Date getDateUnixtime(long unixTime) {
        return new Date(unixTime * 1000);
    }

    public static int getIntUnixtime() {

        return (int) getLongUnixTime();
    }

    public static String getCreateTimeToGameNo(Integer createTimeUnixTime) {
        return sdf_datetime_format4.format(createTimeUnixTime * 1000L);

    }

    /**
     * 获得服务器当前日期及时间，以格式为：yyyy-MM-dd HH:mm:ss的日期字符串形式返回
     *
     * @return
     * @author admin
     * @date Mar 11, 2012
     */
    public static String getDateTime() {
        Calendar cale2 = Calendar.getInstance();
        try {
            return sdf_datetime_format.format(cale2.getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.getDateTime():" + e.getMessage());
            return "";
        }
    }

    public static String getFormatDateTime(Date data) {
        try {
            return sdf_datetime_format.format(data);
        } catch (Exception e) {
            logger.debug("DateUtil.getDateTime():" + e.getMessage());
            return "";
        }
    }

    public static String getFormMonthDate(Date data) {
        try {
            return sdf_datetime_format6.format(data);
        } catch (Exception e) {
            logger.debug("DateUtil.getDateTime():" + e.getMessage());
            return "";
        }
    }

    public static String getHHMMSSDate(Date date) {
        try {
            return sdf_date_format.format(date);
        } catch (Exception e) {
            logger.debug("DateUtil.getDateTime():" + e.getMessage());
            return "";
        }
    }

    public static String getMMSSDate(Date date) {
        try {
            return sdf_datetime_format8.format(date);
        } catch (Exception e) {
            logger.debug("DateUtil.getDateTime():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期，以格式为：yyyy-MM-dd的日期字符串形式返回
     *
     * @return
     * @author admin
     * @date Mar 11, 2012
     */
    public static String getDate() {

        try {
            Calendar cale2 = Calendar.getInstance();
            return sdf_date_format.format(cale2.getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.getDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期，以格式为：yyyyMMdd的日期字符串形式返回
     *
     * @return
     * @author guo
     * @date Mar 11, 2016
     */
    public static String getDateyyyyMMdd() {
        try {

            Calendar cal1 = Calendar.getInstance();
            return sdf_date_formatyyyyMMdd.format(cal1.getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.getDate():" + e.getMessage());
            return "";
        }
    }

    public static String formatUnixTime(long unixTime) {
        return sdf_date_formatyyyyMMdd.format(new Date(unixTime * 1000L));
    }

    public static int compareTowDate(Date compareDay, Date todayDate) {
        String compareDayStr = getDateString(compareDay);
        String todayDateStr = getDateString(todayDate);
        return todayDateStr.compareTo(compareDayStr);
    }


    /**
     * 以格式为：yyyyMMdd的日期字符串形式返回
     *
     * @return
     * @author guo
     * @date Mar 11, 2016
     */
    public static String getDateyyyyMMdd(Date date) {
        if (date == null) {
            return "";
        }
        try {
            return sdf_date_formatyyyyMMdd.format(date);
        } catch (Exception e) {
            logger.debug("DateUtil.getDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 以格式为：yyyyMMdd的日期字符串形式返回
     *
     * @return
     * @author guo
     * @date Mar 11, 2016
     */
    public static String getDateyyyyMMdd(long time) {
        try {
            return sdf_date_format.format(new Date(time));
        } catch (Exception e) {
            logger.debug("DateUtil.getDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 以格式为：yyyyMMdd的日期字符串形式返回
     *
     * @return
     * @author guo
     * @date Mar 11, 2016
     */
    public static String getformatyyyyMMdd(Date date) {
        try {
            return sdf_date_format.format(date);
        } catch (Exception e) {
            logger.debug("DateUtil.getDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前时间，以格式为：HH:mm:ss的日期字符串形式返回
     *
     * @return
     * @author admin
     * @date Mar 11, 2012
     */
    public static String getTime() {
        String temp = " ";
        try {
            Calendar cal1 = Calendar.getInstance();
            temp += sdf_hour_format.format(cal1.getTime());
            return temp;
        } catch (Exception e) {
            logger.debug("DateUtil.getTime():" + e.getMessage());
            return "";
        }
    }

    /**
     * 统计时开始日期的默认值
     *
     * @return
     * @author admin
     * @date Mar 11, 2012
     */
    public static String getStartDate() {
        try {
            return getYear() + "-01-01";
        } catch (Exception e) {
            logger.debug("DateUtil.getStartDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 统计时结束日期的默认值
     *
     * @return
     * @author admin
     * @date Mar 11, 2012
     */
    public static String getEndDate() {
        try {
            return getDate();
        } catch (Exception e) {
            logger.debug("DateUtil.getEndDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期的年份
     *
     * @return
     * @author admin
     * @date Mar 11, 2012
     */
    public static String getYear() {
        try {
            Calendar cale2 = Calendar.getInstance();
            return String.valueOf(cale2.get(Calendar.YEAR));
        } catch (Exception e) {
            logger.debug("DateUtil.getYear():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期的月份
     *
     * @return
     * @author admin
     * @date Mar 11, 2012
     */
    public static String getMonth() {
        try {
            Calendar cale2 = Calendar.getInstance();
            java.text.DecimalFormat df = new java.text.DecimalFormat();
            df.applyPattern("00;00");
            return df.format((cale2.get(Calendar.MONTH) + 1));
        } catch (Exception e) {
            logger.debug("DateUtil.getMonth():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获取当前月日表示 01-30
     *
     * @return
     */
    public static String getNowMD() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get((Calendar.DAY_OF_MONTH)) + "日";
    }

    /**
     * 获得服务器在当前月中天数
     *
     * @return
     * @author admin
     * @date Mar 11, 2012
     */
    public static String getDay() {
        try {
            Calendar cale2 = Calendar.getInstance();
            return String.valueOf(cale2.get(Calendar.DAY_OF_MONTH));
        } catch (Exception e) {
            logger.debug("DateUtil.getDay():" + e.getMessage());
            return "";
        }
    }

    /**
     * 返回默认的日期格式
     *
     * @return
     * @author admin
     * @date Mar 11, 2012
     */
    public static synchronized String getDatePattern() {
        return "yyyy-MM-dd";
    }

    /**
     * 将指定日期按默认格式进行格式代化成字符串后输出如：yyyy-MM-dd
     *
     * @param aDate
     * @return
     * @author admin
     * @date Mar 11, 2012
     */
    public static final String getDate(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";
        if (aDate != null) {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }

    public static long getUnixTime(Date date) {
        return date.getTime() / 1000;
    }

    /**
     * 更加日期获取时间戳 10位
     *
     * @param date
     * @return
     */
    public static int getTimeStamp(Date date) {
        if (date == null) {
            return 0;
        }
        return (int) (date.getTime() / 1000);
    }

    /**
     * 取得当前时间的Calendar日历对象
     *
     * @return
     * @throws ParseException
     * @author admin
     * @date Mar 11, 2012
     */
    public static final Calendar getToday() {
        Calendar cal = null;
        try {
            Date today = new Date();
            SimpleDateFormat df = new SimpleDateFormat(getDatePattern());
            String todayAsString = df.format(today);
            cal = new GregorianCalendar();
            cal.setTime(convertStringToDate(todayAsString));
        } catch (Exception e) {
            return null;
        }

        return cal;
    }

    /**
     * 将日期字符串按指定格式转换成日期类型
     *
     * @param aMask   指定的日期格式，如:yyyy-MM-dd
     * @param strDate 待转换的日期字符串
     * @return
     * @throws ParseException
     * @author admin
     * @date Mar 11, 2012
     */
    public static Date convertStringToDate(String aMask, String strDate) {
        SimpleDateFormat df;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            logger.error("ParseException: " + pe);
            pe.printStackTrace();
        }
        return (date);
    }

    /**
     * 将日期字符串按默认格式转换成日期类型
     *
     * @param strDate
     * @return
     * @throws ParseException
     * @author admin
     * @date Mar 11, 2012
     */
    public static Date convertStringToDate(String strDate) throws ParseException {
        Date aDate = null;

        try {
            if (logger.isDebugEnabled()) {
                logger.debug("converting date with pattern: " + getDatePattern());
            }
            aDate = convertStringToDate(getDatePattern(), strDate);
        } catch (Exception pe) {
            logger.error("Could not convert '" + strDate + "' to a date, throwing exception");

        }
        return aDate;
    }

    public static int getFullYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    public static String getDateString(Date date, String format) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 获取日期类型获取到某天的字符串
     *
     * @param date
     * @return
     */
    public static String getDateString(Date date) {
        return getDateString(date, DATE_FORMAT);
    }

    public static String getDateYMDHMS(Date date) {
        return getDateString(date, DATETIME_FORMAT);
    }

    public static int getHHmmToUnixTime(String hhmm) {
        String[] hhmmArray = hhmm.split(":");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(hhmmArray[0]));
        cal.set(Calendar.MINUTE, Integer.valueOf(hhmmArray[1]));
        cal.set(Calendar.SECOND, 0);
        return (int) (cal.getTime().getTime() / 1000);
    }

    /**
     * 获取当前时间字符串
     *
     * @return
     */
    public static String getNowTime() {
        Date date = new Date();
        return getDateString(date, DATETIME_FORMAT);
    }

    // 得到当前时间增加天数后的时间
    public static GregorianCalendar getCalendarByDays(int value) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (value != 0) {
            gregorianCalendar.add(Calendar.DAY_OF_MONTH, value);
        }
        gregorianCalendar.get(Calendar.DAY_OF_MONTH);
        return gregorianCalendar;
    }

    /**
     * 得到相对当前的前x分钟, x可正可负
     *
     * @param value int 前x分钟
     * @return Date
     */
    public static GregorianCalendar getCalendarByTime(int value) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (value != 0) {
            gregorianCalendar.add(Calendar.MINUTE, value);
        }
        gregorianCalendar.get(Calendar.MINUTE);
        return gregorianCalendar;
    }

    public static GregorianCalendar getCalendarByMonth(int value) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (value != 0) {
            gregorianCalendar.add(Calendar.MONTH, value);
        }
        gregorianCalendar.get(Calendar.MONTH);
        return gregorianCalendar;
    }

    public static Date parse(String date) {
        Date res = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 小写的mm表示的是分钟
            res = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static Date parse2(String date, String format) {
        Date res = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);// 小写的mm表示的是分钟
            res = sdf.parse(date);
        } catch (ParseException e) {
            logger.error("日期转换异常:" + e.getMessage());
        }
        return res;
    }

    /**
     * parse字符串为具体到秒
     *
     * @return
     */
    public static Date parse2DateTime(String date) {
        return parse2(date, DATETIME_FORMAT);
    }

    /**
     * parse字符串为具体到日
     *
     * @return
     */
    public static Date parse2Date(String date) {
        return parse2(date, DATE_FORMAT);
    }

    /**
     * 取得当天0点的时间戳 long 13位
     *
     * @return
     */
    public static long getUnixtimestampToday() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime().getTime();
    }

    /**
     * 当天时间设置 时，分，秒
     *
     * @return
     */
    public static long setUnixtimestampToday(Calendar todayStart, int hour, int minute, int second) {
        todayStart.set(Calendar.HOUR_OF_DAY, hour);
        todayStart.set(Calendar.MINUTE, minute);
        todayStart.set(Calendar.SECOND, second);
        return todayStart.getTime().getTime();
    }

    public static int setUnixtimestampToday(Date date, int hour, int minute, int second) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(date);
        todayStart.set(Calendar.HOUR_OF_DAY, hour);
        todayStart.set(Calendar.MINUTE, minute);
        todayStart.set(Calendar.SECOND, second);
        return (int) (todayStart.getTime().getTime() / 1000);
    }

    public static Date setDateTimes(Date date, int hour, int minute, int second) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(date);
        todayStart.set(Calendar.HOUR_OF_DAY, hour);
        todayStart.set(Calendar.MINUTE, minute);
        todayStart.set(Calendar.SECOND, second);
        return todayStart.getTime();
    }

    /**
     * 设置日期的分钟数
     */
    public static Date setDateMinutes(Date date, int minutes) {
        if (date == null) {
            return new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    /**
     * 获取凌晨时间戳
     *
     * @return
     */
    public static int getTodayTimestamp() {
        return (int) (getUnixtimestampToday() / 1000);
    }

    /**
     * 计算剩余天数 返回 x天x小时x分
     *
     * @param time
     */
    public static String countRemainingDays(long time) {
        String str = "";
        long day = time / 86400;
        long hours = (time - (day * 86400)) / 3600;
        long mins = (time - (day * 86400) - hours * 3600) / 60;
        if (day > 0) {
            str += day + "天";
        }
        if (hours > 0) {
            str += (day > 0 ? "，" : "") + hours + "小时 ";
        }
        if (mins > 0) {
            str += (hours > 0 ? "，" : "") + mins + "分";
        }
        return str;
    }

    /**
     * 返回时间戳 10位 int类型
     *
     * @param date
     * @return int类型 10位时间戳
     */
    public static int parseDateStr2Int(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_MINUTE);
        Date d = null;
        try {
            d = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            logger.error("类型转换异常： " + e.getMessage());
        }
        return (int) (d.getTime() / 1000);
    }

    /**
     * yyyy-mm-dd HH:mm:ss 转换为时间戳
     *
     * @param date
     * @return
     */
    public static int parseYMDHMS2Int(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMAT);
        Date d = null;
        try {
            d = simpleDateFormat.parse(date);
            return (int) (d.getTime() / 1000);
        } catch (ParseException e) {
            logger.error("类型转换异常： " + e.getMessage());
            return 0;
        }

    }

    public static Date parse2DateMm(String date) {
        return parse2(date, DATETIME_MINUTE);
    }

    /**
     * 将时间戳转换为时间格式字符串
     *
     * @param time
     * @return
     */
    public static String parseInt2DateStr(Integer time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_MINUTE);
        long time2 = time;
        String dateStr = simpleDateFormat.format(time2 * 1000);
        return dateStr;
    }

    /**
     * 将时间戳转换为时间格式字符串    yyyy-MM-dd HH:mm:ss
     *
     * @param time
     * @return
     */
    public static String parseInt3DateStr(Integer time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMAT);
        long time3 = time;
        String dateStr = simpleDateFormat.format(time3 * 1000);
        return dateStr;
    }

    /**
     * 将日期类型转换为 String类型 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String parseDate2Str(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMAT);
        String dateStr = simpleDateFormat.format(date);
        return dateStr;
    }

    /**
     * 返回本周一的yyyyMMdd的时间字符串
     *
     * @return
     */
    public static String dayOfWeek() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        Calendar cal = Calendar.getInstance();
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        cal.add(Calendar.DATE, -day_of_week + 1);

        return simpleDateFormat.format(cal.getTime());
    }

    /**
     * 返回本周一的时间戳
     *
     * @return
     */
    public static long getDayOfWeekTime() {
        String time = dayOfWeek();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            return simpleDateFormat.parse(time).getTime();
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
        return -1;
    }

    /**
     * 可以设置当前时间的 时、分、秒
     *
     * @param hours
     * @param minutes
     * @param second
     * @return
     */
    public static Date setNowTime(int hours, int minutes, int second) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    /**
     * 秒数位归零
     *
     * @param date
     * @return
     */
    public static Date cleanSecond(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 返回当前小时分钟的描述总和
     *
     * @return
     */
    public static long getCurHourMin() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        long hour = calendar.get(Calendar.HOUR_OF_DAY) * 60 * 60;
        long min = calendar.get(Calendar.MINUTE) * 60;
        return hour + min;
    }

    /**
     * 返回指定小时分钟的描述总和
     *
     * @param date
     * @return
     */
    public static int getCurHourMin(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY) * 60 * 60;
        int min = calendar.get(Calendar.MINUTE) * 60;
        return hour + min;
    }

    /**
     * @param date
     * @return
     */
    public static String getCurHourMin(int date) {
        int hour = date / 3600;
        int minute = (date - hour * 3600) / 60;
        String time = "";
        if (hour < 10 && minute > 10) {
            time = "0" + hour + ":" + minute;
        } else if (hour > 10 && minute < 10) {
            time = hour + ":" + "0" + minute;
        } else if (hour < 10 && minute < 10) {
            time = "0" + hour + ":" + "0" + minute;
        } else {
            time = hour + ":" + minute;
        }
        return time;
    }

    /**
     * 判断当前时间是否可以举牌
     *
     * @return
     */
    public static boolean isInDate() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int minuteOfDay = hour * 60 + minute;
        final int start = 15 * 60 + 10;// 起始时间 15:10的分钟数
        final int end = 9 * 60 + 25;// 结束时间 9:25
        return minuteOfDay >= start || minuteOfDay <= end;
    }

    /**
     * 判断是否是今天9:27
     *
     * @return
     */
    public static boolean isBeforeMin(int min) {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int minuteOfDay = hour * 60 + minute;
        final int time = 9 * 60 + min;
        return minuteOfDay <= time;
    }

//    /**
//     * 获取指定日期的时间类型
//     *
//     * @param date
//     * @param field 日期类型
//     * @return
//     */
//    public static Date getSpecDate(Date date, int field) {
//        return org.apache.commons.lang.time.DateUtils.truncate(date, field);
//    }

//    /**
//     * 获取指定日期类型为 yyyy-MM-dd
//     *
//     * @return
//     */
//    public static Date getDate2Day() {
//        return getSpecDate(new Date(), Calendar.DATE);
//    }
//
//    /**
//     * 获取指定日期类型为 yyyy-MM-dd
//     *
//     * @return
//     */
//    public static Date getDate2Day(Date date) {
//        return getSpecDate(date, Calendar.DATE);
//    }

    /**
     * 修改日期年份
     *
     * @param date
     * @return
     */
    public static Date getDateSubYear(Date date, int subNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, subNum);
        return calendar.getTime();
    }

    /**
     * 修改日期月份
     *
     * @param date
     * @return
     */
    public static Date optMonth(Date date, int subNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, subNum);
        return calendar.getTime();
    }

    /**
     * 获取当前时间减去interivalMinute
     *
     * @return
     */
    public static Date getDateSubMinute(Date date, int interivalMinute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, -interivalMinute);
        return calendar.getTime();
    }

    /**
     * 获取指定时间
     *
     * @return
     */
    public static Date getDateOptMonthOfFirstDay(Date date, int optMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, optMonth);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取指定时间 改变天数
     *
     * @return
     */
    public static Date getDateOptDay(Date date, int optDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, optDay);
        return calendar.getTime();
    }

//    /**
//     * 获取指定时间 改变小时数
//     *
//     * @return
//     */
//    public static Date getDateOptHour(Date date, int optHour) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.HOUR_OF_DAY, optHour);
//        return getSpecDate(calendar.getTime(), Calendar.SECOND);
//    }

    /**
     * 获取指定时间 改变分钟数
     *
     * @return
     */
    public static Date getDateOptMinute(Date date, int optMinute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, optMinute);
        return calendar.getTime();
    }

    /**
     * 获取指定时间减去subMinute
     *
     * @return
     */
    public static Date getDateOptSeconds(Date date, int optSeconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, optSeconds);
        return calendar.getTime();
    }

    /**
     * 获取指定时间减去月份
     *
     * @return
     */
    public static Date getDateOptMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

//    /**
//     * 获取当前时间减去一hour
//     *
//     * @return
//     */
//    public static Date getDateSubHour(Date date) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.HOUR_OF_DAY, -1);
//        return getSpecDate(calendar.getTime(), Calendar.SECOND);
//    }

//    /**
//     * 修改日期
//     *
//     * @return
//     */
//    public static Date getDateOptDate(Date date, int optNum) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.HOUR_OF_DAY, optNum);
//        return getSpecDate(calendar.getTime(), Calendar.SECOND);
//    }

    /**
     * 获取指定时间+interivalMinute
     *
     * @return
     */
    public static Date getDatePlusMinute(Date date, int interivalMinute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, interivalMinute);
        return calendar.getTime();
    }

//    /**
//     * 获取昨天日期
//     *
//     * @return yyyy-MM-dd
//     */
//    public static Date getYesterday() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, -1);
//        return getSpecDate(calendar.getTime(), Calendar.DATE);
//    }

    /**
     * 距离指定时间还剩多少秒
     *
     * @param date
     * @return
     */
    public static int getRemainSeconds(Date date, int intervalMinute) {
        return (int) ((date.getTime() - Calendar.getInstance().getTimeInMillis()) / 1000) + intervalMinute * 60;
    }

    /**
     * 获取本周一开盘时间
     *
     * @return
     */
    public static Date getMonday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取本周一开盘时间
     *
     * @return
     */
    public static Date getFriday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当天时间
     * 00:00:00
     *
     * @return
     */
    public static int getToday0() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 1);
        calendar.set(Calendar.SECOND, 0);
        return (int) (calendar.getTime().getTime() / 1000);
    }

    /**
     * 设置指定日期时分秒归零
     * @param date
     * @return
     */
    public static Date getZeroHMS(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
//
//    /**
//     * 返回最近周六日期，格式yyyy-MM-dd
//     *
//     * @return
//     */
//    public static Date getSaturday() {
//        Calendar calendar = Calendar.getInstance();
//        int week = calendar.get(Calendar.DAY_OF_WEEK);
//        //7 : 周六
//        if (week == 7) {
//            return DateUtils.getSpecDate(calendar.getTime(), Calendar.DATE);
//        } else {
//            calendar.add(Calendar.DAY_OF_YEAR, -week);
//            return DateUtils.getSpecDate(calendar.getTime(), Calendar.DATE);
//        }
//    }

    /**
     * 获得当前设置小时和分钟的时间戳
     *
     * @param hours
     * @param minutes
     * @return
     */
    public static long setNowTimeByhoursMinutes(int hours, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime().getTime() / 1000;
    }

    /**
     * 获取指定时间，指定格式的字符串
     *
     * @param date
     * @return
     */
    public static String timeDate2Str(Date date, String formatStr) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(calendar.getTime());
    }

    /**
     * 从指定格式的时间转为 Date
     *
     * @param time
     * @param formatStr
     * @return
     */
    public static int timeStr2Int(String time, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        try {
            return (int) (format.parse(time).getTime() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Date timeStr2Date(String time, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        try {
            return format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * 获取当前日期，
     */
    public static int getCurDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int setday(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return (int) (calendar.getTime().getTime() / 1000L);
    }

    /**
     * 根据周几获取时间
     *
     * @param week
     * @return
     */
    public static Date getDateByWeek(int week) {
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_WEEK, week);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        return cal.getTime();
    }

    /**
     * 判断两个日期是否在同一天
     *
     * @return
     */
    public static boolean isDateEquals(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance(Locale.CHINA);
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance(Locale.CHINA);
        cal2.setTime(date2);

        if (cal1.get(Calendar.MONTH) != cal2.get(Calendar.MONTH)) {
            return false;
        }

        return cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    public static long timeStr2Long(String time, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        try {
            return format.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getFormatTime(long time, String Sdf) {
        SimpleDateFormat format = new SimpleDateFormat(Sdf, Locale.CHINA);
        return format.format(new Date(time));
    }

    public static String getFormatTime(String Sdf) {
        SimpleDateFormat format = new SimpleDateFormat(Sdf, Locale.CHINA);
        return format.format(new Date());
    }

    /**
     * 人性化时间显示
     *
     * @param createAt 毫秒
     * @return
     */
    public static String getRelativeTime(long createAt) {
        long diffSecond = (System.currentTimeMillis() - createAt) / 1000;

        if (diffSecond <= 0) {
            diffSecond = 0;
        }

        if (diffSecond < MINUTE) {
            return "刚刚";
        }

        if (diffSecond >= MINUTE && diffSecond < HOUR) {
            long minute = diffSecond / 60;
            return minute + "分钟前";
        }

        if (diffSecond >= HOUR && diffSecond < DAY) {
            long hour = diffSecond / HOUR;
            if (hour <= 3) {
                return hour + "小时前";
            }
        }

        long today = DateUtils.getDateByHourAndMin(0, 0).getTime();
        if (createAt > today) {
            return "今天 " + getFormatTime(createAt, "HH:mm");
        }

        if (createAt < today && createAt >= today - DAY * 1000) {
            return "昨天" + getFormatTime(createAt, "HH:mm");
        }

        if (diffSecond <= DAY * 7) {
            long day = (long) Math.ceil((double) diffSecond / DAY);
            return day + "天前";
        }
        if (diffSecond > DAY * 7 && diffSecond < YEAR) {
            return getFormatTime(createAt, "MM-dd HH:mm");
        }

        if (diffSecond >= YEAR) {
            return getFormatTime(createAt, "YYYY-MM-dd HH:mm");
        }

        return "";
    }

    /**
     * 由时间分钟生成 date
     *
     * @param hour
     * @param min
     * @return
     */
    public static Date getDateByHourAndMin(int hour, int min) {
        return getDateByHourAndMin(new Date(), hour, min);
    }

    public static Date getDateByHourAndMin(Date curDate, int hour, int min) {
        if (curDate == null) {
            curDate = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curDate);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * 比对某个时间是否落在一个区间内
     *
     * @param beforeDate
     * @param afterDate
     * @param curDate
     * @return
     */
    public static boolean isBetween(Date beforeDate, Date afterDate, Date curDate) {
        return beforeDate.compareTo(curDate) <= 0 && afterDate.compareTo(curDate) >= 0;
    }

    /**
     * 比对某个时间是否落在一个区间内
     *
     * @param beforeHour
     * @param beforeMin
     * @param afterHour
     * @param afterMin
     * @param curDate
     * @return
     */
    public static boolean isBetween(int beforeHour, int beforeMin, int afterHour, int afterMin, Date curDate) {
        return isBetween(
                DateUtils.getDateByHourAndMin(curDate, beforeHour, beforeMin),
                DateUtils.getDateByHourAndMin(curDate, afterHour, afterMin),
                curDate);
    }

    /**
     * 获取上午开盘时间
     *
     * @return
     */
    public static Date getAMOpenTime(Date curDate) {
        return getDateByHourAndMin(curDate, 9, 30);
    }

    /**
     * 获取上午收盘时间
     *
     * @return
     */
    public static Date getAMCloseTime(Date curDate) {
        return getDateByHourAndMin(curDate, 11, 30);
    }

    /**
     * 获取下午开盘时间
     *
     * @return
     */
    public static Date getPMOpenTime(Date curDate) {
        return getDateByHourAndMin(curDate, 13, 0);
    }

    /**
     * 获取下午收盘时间
     *
     * @return
     */
    public static Date getPMCloseTime(Date curDate) {
        return getDateByHourAndMin(curDate, 15, 0);
    }

    /**
     * @Description: 将date日期转换为格式： ”2017-05-24“
     * @Param: date 要转换的参数
     * @Author: zhulz
     * @Date: 11:09 2017/7/24
     * @Return : 转换后的格式date
     */
    public static Date getDateFormat(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DATE);
        String str = y + "-" + m + "-" + d;
        Date dates = java.sql.Date.valueOf(str);
        return dates;
    }

    /**
     * @param hour
     * @param minute
     * @return
     */
    public static Calendar getCalendarByNum(int hour, int minute, Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal;
    }

    //获取指定日期所在周范围（周一至周五）
    public static String getWeekRange(Calendar cal) {
        SimpleDateFormat format = new SimpleDateFormat("MMdd");
        int d;
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        // 所在周开始日期
        cal.add(Calendar.DAY_OF_WEEK, d);
        String dataStart = format.format(cal.getTime());

        // 所在周结束日期
        cal.add(Calendar.DAY_OF_WEEK, 4);
        String dataEnd = format.format(cal.getTime());

        return dataStart + "-" + dataEnd;
    }

    /**
     * 拼装时间,返回十位时间戳
     *
     * @param date
     * @param times "09:15:00"
     * @return
     */
    public static int assembleDate(Date date, String times) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        String arrays[] = times.split(":");
        calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(arrays[0]));
        calendar.set(Calendar.MINUTE, Integer.valueOf(arrays[1]));
        calendar.set(Calendar.SECOND, Integer.valueOf(arrays[2]));
        calendar.set(Calendar.MILLISECOND, 0);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

//    public static void main(String[] args) {
//        Date date = new Date(1532225480000l);
//        System.out.println(getWeekOfDate(date));
//    }


    /**
     * 获取 dayNum 天前及后的自然日 yyyy-MM-dd 00:00:00
     *
     * @param dayNum        前后推因子
     * @param curDate      当前日期
     * @param addType      方向 0 向前 1 向后
     * @return
     */
    public static Date getPreOrPostNaturalDays(int dayNum, int addType, Date curDate){
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(curDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        int addNum = dayNum;
        //向前推 addNum 为 -dayNum
        if (addType == 0){
            addNum = -dayNum;
        }
        calendar.add(Calendar.DAY_OF_YEAR, addNum);

        return calendar.getTime();
    }
}
