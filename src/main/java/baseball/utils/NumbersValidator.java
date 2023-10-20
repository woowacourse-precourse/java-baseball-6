package baseball.utils;

public class NumbersValidator {
    /*
     * 사용자 입력 값의 유효성 검사
     */
    public static void inputValidate(String input) {
        if (input.length() != 3 || isNotInteger(input)) {
            throw new IllegalArgumentException();
        }
    }

    /*
     * 문자열이 숫자형태인지 판별
     *
     * @return true : 숫자 X, false : 숫자
     */
    public static boolean isNotInteger(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException numberFormatException) {
            return true;
        }
    }
}
