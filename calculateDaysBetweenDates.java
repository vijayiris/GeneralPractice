public class calculateDaysBetweenDates {

    public static int daysBetweenDates(String date1, String date2) {
        String[] parts1 = date1.split("-");
        String[] parts2 = date2.split("-");

        int year1 = Integer.parseInt(parts1[0]);
        int month1 = Integer.parseInt(parts1[1]);
        int day1 = Integer.parseInt(parts1[2]);

        int year2 = Integer.parseInt(parts2[0]);
        int month2 = Integer.parseInt(parts2[1]);
        int day2 = Integer.parseInt(parts2[2]);

        // Calculate the total number of days from year 0 to the given dates
        int totalDays1 = calculateTotalDays(year1, month1, day1);
        int totalDays2 = calculateTotalDays(year2, month2, day2);

        // Return the absolute difference between the two totals
        return Math.abs(totalDays1 - totalDays2);
    }

    private static int calculateTotalDays(int year, int month, int day) {
        int totalDays = day;

        // Add days for the months in the current year
        for (int m = 1; m < month; m++) {
            totalDays += getDaysInMonth(year, m);
        }

        // Add days for the years before the current year
        for (int y = 0; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        return totalDays;
    }

    private static int getDaysInMonth(int year, int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }

        }

    public static void main(String[] args) {
        java.time.LocalDate today = java.time.LocalDate.now();
        String currentDate = today.toString(); // Format: yyyy-MM-dd
        String targetDate = "2026-10-13";

        int days = daysBetweenDates(currentDate, targetDate);
        System.out.println("001B[1;34mNumber of days between " + currentDate + " and Arnav Birthday date is: " + days );
    }

    }