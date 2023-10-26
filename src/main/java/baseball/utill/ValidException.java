package baseball.utill;

import baseball.string.ValidConstants;

public class ValidException {
    public final static int LENGTH_ALLOW_TREE = 3;
    private static final int NOT_AGAIN_GAME = 2;
    private static final int WANT_AGAIN_GAME = 1;

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


    /**
     * 유저가 3자릿수의 랜덤 숫자을 입력할때 1과 2가 아니면 예외 발생을 한다.
     *
     * @param num
     */
    public static void isValidOnlyInputOneTwo(int num) {
        if (Utill.isSameInteger(num, WANT_AGAIN_GAME) || Utill.isSameInteger(num, NOT_AGAIN_GAME)) {
            return;
        }
        throw new IllegalArgumentException(ValidConstants.MSG_INPUT_LENGTH_ONLY_THREE());
    }

    /**
     * 숫자 타입으로 입력 예외처리
     *
     * @param str
     */
    public static void isValidNumVerification(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidConstants.MSG_ONLY_INPUT_NUM_TYPE());
        }
    }

    /**
     * 양수 입력을 위한 예외 처리.
     *
     * @param num
     */
    public static void isValidPositiveInt(String num) {
        if (Integer.valueOf(num) > 0) {
            return;
        }
        throw new IllegalArgumentException(ValidConstants.MSG_INPUT_POSITIVE_NUM());
    }

    /**
     * 숫자입력에 대한 기본 적인 예외처리
     * 숫자타입, 양수검사
     */
    public static void isValidBasicNumException(String inputStr) {
        ValidException.isValidNumVerification(inputStr); // 입력 받은 문자열이 숫자로 변환 가능한지 확인
        ValidException.isValidPositiveInt(inputStr); // 입력 받은 문자열이 양수로 인지 확인
    }

    /**
     * 게임의 힌트가 적절한 값이 없이 끝날때.
     *
     * @return
     */
    public static String isValidNotAccuracyGameResult() {
        throw new IllegalArgumentException(ValidConstants.MSG_NOT_ACCURACY_GAME_RESULT());
    }
}
