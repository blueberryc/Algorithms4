package Ch_1_2_Data_Abstraction;

import java.util.HashSet;
import java.util.Random;

/**
 * Created by Zive on 2019-01-15.
 */
public class Practice_1_2_11 {
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++)
            System.out.println(SmartDate.randomDate());
    }
}

class SmartDate {
    private final int month;
    private final int day;
    private final int year;
    private static final HashSet<Integer> maxMonth = new HashSet<>(){{
        // 大月，每个月的天数为31天
        add(1);
        add(3);
        add(5);
        add(7);
        add(8);
        add(10);
        add(12);
    }};
    private static final HashSet<Integer> minMonth = new HashSet<>(){{
        // 小月，每个月的天数为30天，2月要额外考虑
        add(2);
        add(4);
        add(6);
        add(9);
        add(11);
    }};

    public SmartDate(int mm, int dd, int yy){
        if (yy < 0){
            throw new RuntimeException("year should not be negative number");
        }
        if (maxMonth.contains(mm) && (dd < 1 || dd > 31)){
            throw new RuntimeException("day should in [1, 31]");
        }
        if (minMonth.contains(mm) && mm != 2){
            if (dd < 1 || dd > 30){
                throw new RuntimeException("day should in [1, 30]");
            }
        } else if (minMonth.contains(mm) && mm == 2){
            // 闰年
            if ((yy % 4 == 0 && yy % 100 != 0) || yy % 400 == 0){
                if (dd < 1 || dd > 29){
                    throw new RuntimeException("day should in [1, 29]");
                }
            }else {
                // 平年
                if (dd < 1 || dd > 28){
                    throw new RuntimeException("day should in [1, 28]");
                }
            }
        }
        if (mm < 1 || mm > 12){
            throw new RuntimeException("month should in [1, 12]");
        }

        month = mm;
        day = dd;
        year = yy;
    }

    private static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    private static int[] daysPerMonth(int year){
        // 返回当年每个月的天数
        if (year < 1){
            throw new RuntimeException("year should not be negative number");
        }
        int[] daysOfMonth = new int[12];
        for (int i = 1; i <= 12; i++){
            if (maxMonth.contains(i)){
                daysOfMonth[i-1] = 31;
            }
            if (minMonth.contains(i) && i != 2){
                daysOfMonth[i-1] = 30;
            }else if (minMonth.contains(i) && i == 2){
                if (isLeapYear(year)){
                    daysOfMonth[i-1] = 29;
                }else {
                    daysOfMonth[i-1] = 28;
                }
            }
        }
        return daysOfMonth;
    }

    public int dayOfTheWeek(){
        int days = 0;
        for (int i = 1; i < this.year; i++){
            // 计算当年前所有年的天数
            int[] daysOfMonth = daysPerMonth(i); // 每月的天数
            for (Integer day : daysOfMonth){
                days += day;
            }
        }
        int[] curYear = daysPerMonth(this.year); // 本年每月的天数
        for (int i = 0; i < this.month-1; i++) {
            // 计算到前一月的总天数
            days += curYear[i];
        }
        return (days + this.day) % 7 + 1;
    }
    static SmartDate randomDate(){
        // 随机生成一个有效的日期
        Random rand = new Random();
        int year = rand.nextInt(2051 - 1900) + 1900;
        int month = rand.nextInt(12) + 1;
        int[] dayOfMonth = daysPerMonth(year);
        int day = rand.nextInt(dayOfMonth[month-1]) + 1;
        return new SmartDate(month, day, year);
    }

    String weekdayString(int weekday){
        switch (weekday){
            case 1:return "一";
            case 2:return "二";
            case 3:return "三";
            case 4:return "四";
            case 5:return "五";
            case 6:return "六";
            case 7:return "日";
            default:
                throw new RuntimeException("year should not be negative number");
        }
    }

    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public int getYear(){
        return year;
    }
    public String toString(){
        return getMonth() + "/" + getDay() + "/" + getYear() + " [" + weekdayString(dayOfTheWeek()) + "]";
    }
}
