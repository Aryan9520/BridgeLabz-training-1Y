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

    public static int getFirstDay(int month, int year) {
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
        return (h + 6) % 7; // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
    }

    public static String getMonthName(int month) {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[month - 1];
    }

    public static void displayCalendar(int month, int year) {
        int firstDay = getFirstDay(month, year);
        int totalDays = getDaysInMonth(month, year);

        System.out.println("\n   " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // First for loop: indentation till first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Second for loop: print days of the month
        for (int day = 1; day <= totalDays; day++) {
            System.out.printf("%3d ", day);

            // Move to next line after Saturday
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Invalid month! Enter between 1 and 12.");
            return;
        }

        displayCalendar(month, year);
    }
}
