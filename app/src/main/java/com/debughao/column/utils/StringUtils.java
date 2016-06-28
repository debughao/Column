package com.debughao.column.utils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/28 18:14
 * description :
 */
public class StringUtils {

    /**
     * 拆分含有"-"字符串
     * @param str
     * @return
     */
    public static String[] splitStrToArry(String str) {
        String[] strArray = null;
        strArray = str.split("-");
        return strArray;
    }

    /**
     * 金额格式化 例如555455.22
     *
     * @param string
     * @return String
     */
    public static String getThousandNum(String string) {
        String string2 = string.substring(0, string.indexOf("."));
        return string2.replaceAll("(?<=\\d)(?=(?:\\d{3})+$)", ",") + string.substring(string.indexOf("."), string.length());
    }

    public static String getMoneyNum(double string) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(string);
    }

    /**
     * 数字格式话 例如：10000 显示10K
     * @param d
     * @return
     */
    public static String formatNum(String d) {
        long paramLong = Long.parseLong(d);
        if (paramLong < 1000L)
            return String.valueOf(paramLong);
        if ((paramLong >= 1000L) && (paramLong < 10000L))
            return new DecimalFormat("0.0K").format(paramLong / 100L / 10.0D);
        if ((paramLong >= 10000L) && (paramLong < 100000L))
            return new DecimalFormat("0k").format(paramLong / 1000L);
        if ((paramLong >= 100000L) && (paramLong < 10000000L))
            return new DecimalFormat("0W").format(paramLong / 10000L);
        return "+∞";
    }

    /**
     * 获取昨天日期
     *
     * @return String
     */
    public static String getYestDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal
                .getTime());
        return yesterday;
    }

    /**
     * 获取最近一周日期
     *
     * @return String[]
     */
    public static String[] getNearWeek() {
        String[] strArray = new String[7];
        Calendar cal = Calendar.getInstance();
        for (int i = 1; i <= 7; i++) {
            cal.add(Calendar.DATE, -1);
            strArray[i - 1] = new SimpleDateFormat("yyyy-MM-dd").format(cal
                    .getTime());
        }
        return strArray;
    }

    /**
     * 判断字符串是否为url
     *
     * @return String[]
     */
    public static boolean isInternetURL(String str) {
        return str.startsWith("http");
    }


//    /**
//     *修改网页片段img标签src，添加主机域名
//     * @param baseHtml
//     * @return
//     */
//    public static String replaceImgTagFromHTML(String baseHtml) {
//        Document doc = Jsoup.parse(baseHtml);
//        Elements es = doc.getElementsByTag("img");
//        for (Element e : es) {
//            String imgUrl = e.attr("src");
//            e.attr("src" , AppConstants.HOSTIP + imgUrl);
//            // LogUtil.e("imgUrl-----------"+imgUrl);
//        }
//        return doc.html();
//    }
}
