package com.lefinance.common.utils;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created with: jingyan.
 * Date: 2016/9/16  23:03
 * Description:
 */
public class PubMethod {


    /**
     * 获得异常的详细信息
     *
     * @param e
     * @return
     */
    public static String getStackTraceString(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

    /**
     * Created with: jingyan.
     * Date: 2016/9/25  18:41
     * Description: 各种非空判断
     */
    public static boolean isEmpty(String Value) {
        return (Value == null || Value.trim().equals(""));
    }

    public static boolean isEmpty(StringBuffer Value) {

        return (Value == null || (Value.toString().trim()).equals(""));
    }

    public static boolean isEmpty(List list) {
        if (list == null || list.size() == 0)
            return true;
        else
            return false;
    }

    public static boolean isEmpty(Set set) {
        if (set == null || set.size() == 0)
            return true;
        else
            return false;
    }

    public static boolean isEmpty(Map map) {
        if (map == null || map.size() == 0)
            return true;
        else
            return false;
    }

    public static boolean isEmpty(Object Value) {
        if (Value == null)
            return true;
        else
            return false;
    }

    public static boolean isEmpty(Double value) {
        if (value == null || value.doubleValue() == 0.0)
            return true;
        else
            return false;
    }

    public static boolean isEmpty(Long obj) {
        if (obj == null || obj.longValue() == 0)
            return true;
        else
            return false;
    }

    public static boolean isEmpty(Object[] Value) {
        if (Value == null || Value.length == 0)
            return true;
        else
            return false;
    }

    /**
     * Created with: jingyan.
     * Date: 2016/9/25  19:06
     * Description: 生成随机字符串
     */
    public static String getRandomStr(int length) {
        if (length < 1) {
            return null;
        }
        StringBuilder result = new StringBuilder("");
        char[] allChars = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'X'};
        for (int i = 0; i < length; i++) {
            int index = new Random().nextInt(allChars.length);
            result.append(allChars[index]);
        }
        return result.toString();
    }

    /**
     * Created with: jingyan.
     * Date: 2016/12/8  14:36
     * Description: 数字大写
     */
    public static String numToUpper(int num) {
        // String u[] = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        String u[] = {"〇", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        char[] str = String.valueOf(num).toCharArray();
        String rstr = "";
        for (int i = 0; i < str.length; i++) {
            rstr = rstr + u[Integer.parseInt(str[i] + "")];
        }
        return rstr;
    }

    /**
     * Created with: jingyan.
     * Date: 2016/9/25  18:42
     * Description: 按要求切割字符串
     */
    public static String[] splitString(String srcStr, String splitter) {
        if (srcStr == null) return new String[]{""};
        String[] tmpArr = srcStr.split(splitter);
        if (tmpArr == null || tmpArr.length == 0) {
            return new String[]{""};
        } else {
            for (int index = 0; index < tmpArr.length; index++) {
                tmpArr[index] = tmpArr[index].trim();
            }
            return tmpArr;
        }
    }

    /**
     * Created with: jingyan.
     * Date: 2016/9/25  18:48
     * Description: 数字前面补0 返回字符串
     */
    public static String int2Str(int intValue, int strLength) {
        if (strLength > 0) {
            char padding = '0';
            StringBuilder result = new StringBuilder();
            String fromStr = String.valueOf(intValue);
            for (int i = fromStr.length(); i < strLength; i++) {
                result.append(padding);
            }
            result.append(fromStr);
            return result.toString();
        } else {
            return null;
        }
    }

    /**
     * Created with: jingyan.
     * Date: 2016/9/25  19:11
     * Description: str to date
     */
    public static Date str2Date(String strDate, String strFormat) {
        if (isEmpty(strFormat)) {
            strFormat = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {

        }
        return date;
    }

    /**
     * Created with: jingyan.
     * Date: 2016/10/25  14:43
     * Description: date to str
     */
    public static String date2Str(Date date, String formatStr) {
        if (PubMethod.isEmpty(formatStr)) {
            formatStr = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        String formatDate = sdf.format(date);
        return formatDate;
    }

    /**
     * Created with: jingyan.
     * Date: 2016/9/25  17:43
     * Description: 获取当前时间字符串
     */
    public static String getDateStr(String formatStr) {
        if (PubMethod.isEmpty(formatStr)) {
            formatStr = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        Date date = new Date();
        String formatDate = sdf.format(date);
        return formatDate;
    }

    /**
     * Created with: jingyan.
     * Date: 2017/2/16  17:13
     * Description: 获取时间年月日数字
     */
    public static int[] getDateNum(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        int[] dateNums = new int[3];
        dateNums[0] = rightNow.get(Calendar.YEAR);
        dateNums[1] = rightNow.get(Calendar.MONTH) + 1;
        dateNums[2] = rightNow.get(Calendar.DAY_OF_MONTH);
        return dateNums;
    }

    /**
     * Created with: jingyan.
     * Date: 2017/2/15  20:28
     * Description: 时间增加处理
     */
    public static Date dateAddNum(Date oldDate, int addYear, int addMonth, int addDay) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(oldDate);
        rightNow.add(Calendar.YEAR, addYear);
        rightNow.add(Calendar.MONTH, addMonth);
        rightNow.add(Calendar.DAY_OF_YEAR, addDay);
        Date newDate = rightNow.getTime();
        return newDate;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/9/20 9:43
     * @Describe: 两个日期计算间隔天数
     * <p>
     * fDate   减数
     * oDate   被减数
     */
    public static int daysBetween(Date fDate, Date oDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fDate);
        long fDateTime = cal.getTimeInMillis();
        cal.setTime(oDate);
        long oDateTime = cal.getTimeInMillis();
        Long intervalDays = (oDateTime - fDateTime) / (1000 * 3600 * 24);
        return intervalDays.intValue();
    }

    /**
     * Created with: jingyan.
     * Date: 2016/10/11  16:37
     * Description: 获取验证码
     */
    public static String generateRandomNum(int MAX, int MIN) {
        Random rand = new Random();
        int randNumber = rand.nextInt(MAX - MIN + 1) + MIN;
        return randNumber + "";
    }

    public static void main(String[] args) {
        long s=System.currentTimeMillis();
        // 1 new 对象
        CsvFileUtil csvWriteUtil = new CsvFileUtil();
        try {
            //2 初始化要写入的文件（true为追加，false为覆盖新写）
            csvWriteUtil.initCsvWriter("D://ccc/bbb/aa.csv", true);
            for (int i = 0; i < 5000; i++) {
                String[] a = {"ASD" + i, "FGH" + i, "HJK" + i, "KLJ" + i, "QWE" + i};
                //3 按行写入
                csvWriteUtil.writeFileByLine(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4  关闭文件
            csvWriteUtil.closeCsvWriter();
        }
        System.out.println(System.currentTimeMillis()-s);
    }
}
