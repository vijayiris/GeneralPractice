public class runnerClass {
    public static void main(String[] args) {
        String mobileNumber = "9876543210"; // Example mobile number
        boolean isValid = validateMobileNumber.isValidMobileNumber(mobileNumber);

        if (isValid) {
            System.out.println("The mobile number " + mobileNumber + " is valid.");
        } else {
            System.out.println("The mobile number " + mobileNumber + " is invalid.");
        }
    }
}
