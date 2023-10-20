package baseball.utill;

import baseball.string.MyConstants;
import baseball.string.ValidConstants;

public class ValidException {
    public final static int LENGTH_ALLOW_TREE = 3;

    /**
     * 문자열의 길이가 3이 아니면 예외 처리
     *
     * @param str
     */
    public static void isValidLength(String str) {
        if (str.length() == LENGTH_ALLOW_TREE) {
            return;
        }
        throw new IllegalArgumentException(ValidConstants.MSG_INPUT_LENGTH_ONLY_THREE());
    }
}
