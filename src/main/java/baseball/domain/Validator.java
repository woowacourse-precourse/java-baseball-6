package baseball.domain;

public class Validator {

    private Validator() {
    }

    public static boolean stringLengthCheck(final String strNum) {
        return strNum.length() == 3;
    }

    public static boolean isNull(final String strNum) {
        return strNum == null;
    }

    public static boolean reStartChecker(String strNum) {
        try {
            if (Integer.parseInt(strNum) == 1) {
                return true;
            } else if (Integer.parseInt(strNum) == 2) {
                return true;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return false;
    }
}
