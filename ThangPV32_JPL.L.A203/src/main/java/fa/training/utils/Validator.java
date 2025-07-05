package fa.training.utils;

public class Validator {
    // Validate phone number: must match pattern and length (ex: 10-11 digits)
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^\\d{10,11}$");
    }

    // Validate order number: must be exactly 10 digits
    public static boolean isValidOrderNumber(String orderNum) {
        return orderNum != null && orderNum.matches("^\\d{10}$");
    }
}
