import java.util.Scanner;

public class CalendarDisplay {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    public static int getFirstDayOfMonth(int month, int year) {
        int m = month;
        int y = year;

        if (m < 3) {
            m += 12;
            y--;
        }

        int q = 1;
        int k = y % 100;
        int j = y / 100;

        int h = (q + (13 * (m + 1)) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;

        int dayOfWeek = (h + 6) % 7; // Convert to 0 = Sunday
        return dayOfWeek;
    }

    public static String getMonthName(int month) {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
