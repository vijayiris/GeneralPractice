public class validateMobileNumber {

    //Create a method to validate a mobile number
    public static boolean isValidMobileNumber(String mobileNumber) {
        // Check if the mobile number is exactly 10 digits long
        if (mobileNumber.length() != 10) {
            System.out.println("Length is not 10");
            return false;

        }


        for (char c : mobileNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
            if (!Character.isDigit(c)) {
                return false;
            }
        }


        char firstDigit = mobileNumber.charAt(0);
        if (firstDigit == '0' || firstDigit == '1') {
            return false;
        }

        return true;
    }
}
