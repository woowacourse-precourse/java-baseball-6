package baseball.utill;

public class ValidException {

    /**
     * 문자열의 길이가 3이 아니면 예외 처리
     *
     * @param str
     */
    public static void isValidLength(String str) {
        if (str.length() == 3) {
            return;
        }
        throw new IllegalArgumentException(ValidString.MSG_INPUT_LENGTH_ONLY_THREE);
    }
}
