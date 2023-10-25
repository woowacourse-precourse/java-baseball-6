package baseball.util.constants;

public class ExceptionMessages {
    public static final String NUMBERS_WRONG_LENGTH = "%d자리만 입력 가능합니다".formatted(
            BaseballGameConstants.NUM_LENGTH);
    public static final String NUMBERS_OUT_OF_RANGE = "%d부터 %d까지 정수만 입력 가능합니다".formatted(
            BaseballGameConstants.MIN_NUM, BaseballGameConstants.MAX_NUM);
    public static final String NUMBERS_DUPLICATED_MESSAGE = "중복값은 입력할 수 없습니다";
    private static final String WRONG_NUMBERS_MESSAGE = "%d부터 %d까지의 서로 다른 %d자리 숫자만 입력 가능합니다. ".formatted(
            BaseballGameConstants.MIN_NUM, BaseballGameConstants.MAX_NUM, BaseballGameConstants.NUM_LENGTH);

}
