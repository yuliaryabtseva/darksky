package framework;

import java.util.Calendar;

public class DateUtils {

    private static Calendar calendar = Calendar.getInstance();

    public static String getCurrentFullDateTime() {
        return calendar.getTime().toString();
    }

    public static int getMonthNumber() {
        return calendar.get(Calendar.MONTH);
    }

    public static int getDayOfMonth() {
        return calendar.get(Calendar.DATE);
    }

    public static void incrementByDays(int days) {
        calendar.add(Calendar.DATE, days);
    }


}
