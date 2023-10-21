package baseball.util;

public class ExceptionMessage {
    public static final String WRONG_NUMBER_LENGTH = String.format("입력 값은 %d자리여야 합니다.", Constants.BALL_LENGTH);
    public static final String NOT_NATURAL_NUMBER = "자연수만 입력 가능합니다.";
    public static final String HAS_DUPLICATED_NUMBER = "중복된 값이 있습니다";
    public static final String NOT_IN_RANGE = String.format("각 숫자는 %d에서 %d 사이여야 합니다", Constants.MIN_BALL_NUMBER,
            Constants.MAX_BALL_NUMBER);
    public static final String WRONG_JUDGE = "잘못된 결과입니다";
}
