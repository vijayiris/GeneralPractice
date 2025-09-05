public class calculateDaysBetweenDates {

/**
 * Calculates the absolute number of days between two dates provided in yyyy-MM-dd format.
 *
 * @param date1 the first date as a String (format: yyyy-MM-dd)
 * @param date2 the second date as a String (format: yyyy-MM-dd)
 * @return the absolute number of days between date1 and date2
 */
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

/**
 * Calculates the total number of days from year 0 to the specified date.
 *
 * This method adds the days for the current month, all previous months in the current year,
 * and all previous years, taking leap years into account.
 *
 * @param year the year part of the date
 * @param month the month part of the date (1-based)
 * @param day the day part of the date
 * @return the total number of days from year 0 to the given date
 */
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

/**
 * Returns the number of days in a given month for a specific year.
 *
 * This method checks the month and returns the correct number of days,
 * accounting for leap years in February. If the month is invalid,
 * it throws an IllegalArgumentException.
 *
 * @param year the year to check for leap year (used for February)
 * @param month the month (1-based, 1 = January, 12 = December)
 * @return the number of days in the specified month
 * @throws IllegalArgumentException if the month is not between 1 and 12
 */
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

/**
 * Main method to demonstrate the calculation of days between the current date and a target date.
 *
 * This method retrieves the current date, sets a target date, calculates the number of days
 * between them using the daysBetweenDates utility, and prints the result to the console.
 *
 * @param args command line arguments (not used)
 */
public static void main(String[] args) {
    java.time.LocalDate today = java.time.LocalDate.now();
    String currentDate = today.toString(); // Format: yyyy-MM-dd
    String targetDate = "2026-10-13";

    int days = daysBetweenDates(currentDate, targetDate);
    System.out.println("001B[1;34mNumber of days between " + currentDate + " and Arnav Birthday date is: " + days );
}

    }