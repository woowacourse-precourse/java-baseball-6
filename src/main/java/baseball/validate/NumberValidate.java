package baseball.validate;

public class NumberValidate {

    public static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
