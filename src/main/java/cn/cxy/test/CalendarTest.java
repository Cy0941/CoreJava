package cn.cxy.test;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/13 9:57 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class CalendarTest {

    public static void main(String[] args){
        GregorianCalendar d = new GregorianCalendar();

        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);

        d.set(Calendar.DAY_OF_MONTH, 1);
        int weekday = d.get(Calendar.DAY_OF_WEEK);

        int firstDayOfWeek = d.getFirstDayOfWeek();

        //当前月份第一天距离当前默认“星期一”的天数
        int indent = 0;
        while (weekday != firstDayOfWeek) {
            indent++;
            d.add(Calendar.DAY_OF_MONTH, -1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }
        //格式化获取 ‘星期’ 字符串数组
        String[] weekdayNames = new DateFormatSymbols(Locale.CHINA).getShortWeekdays();
        do {
            System.out.printf("%4s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek); //TODO

        System.out.println();

        for (int i = 0; i <= indent; i++) {
            System.out.print("    ");
        }

        d.set(Calendar.DAY_OF_MONTH, 1);

        while (d.get(Calendar.MONTH) == month) {
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%4d", day);

            if (day == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }

            d.add(Calendar.DAY_OF_MONTH, 1);

            weekday = d.get(Calendar.DAY_OF_WEEK);
            if (weekday == firstDayOfWeek) {
                System.out.println();
                System.out.print(" ");
            }
        }
    }
}
