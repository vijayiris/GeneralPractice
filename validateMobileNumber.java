public class validateMobileNumber {

    public static boolean isValidMobileNumber(String mobileNumber) {
        // Check if the mobile number is exactly 10 digits long
        if (mobileNumber.length() != 10) {
            return false;
        }

        // Check if all characters are digits
        for (char c : mobileNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        // Check if the first digit is not 0 or 1
        // Assuming the mobile number is in a format where the first digit should not be 0 or 1
        // This is a common rule in many countries for mobile numbers
        char firstDigit = mobileNumber.charAt(0);
        if (firstDigit == '0' || firstDigit == '1') {
            return false;
        }

        return true;
    }
}
