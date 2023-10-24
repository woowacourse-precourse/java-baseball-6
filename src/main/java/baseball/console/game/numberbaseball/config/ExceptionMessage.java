package baseball.console.game.numberbaseball.config;

public class ExceptionMessage {

    // NumberUtils
    public static final String INVALID_FOR_HUNDRED_DIGIT = "백의 자리 수를 구하기에 유효하지 않은 숫자가 전달되었습니다: ";
    public static final String INVALID_FOR_TEN_DIGIT = "십의 자리 수를 구하기에 유효하지 않은 숫자가 전달되었습니다: ";
    public static final String INVALID_FOR_ONE_DIGIT = "일의 자리 수를 구하기에 유효하지 않은 숫자가 전달되었습니다: ";

    // UserPredictionValidator
    public static final String INVALID_NOT_INTEGER = "입력값이 정수가 아닙니다: ";
    public static final String INVALID_NOT_THREE_DIGITS = "입력값은 세 자리 정수이어야 합니다: ";
    public static final String INVALID_HAS_DUPLICATE_DIGITS = "입력값은 각 자리 숫자가 모두 달라야합니다: ";
}
