package baseball.domain;

public class ErrorMessage {

    public static final String BALL_NUMBER_IS_NOT_IN_RANGE = "[ERROR] 입력은 0을 포함할 수 없슴니다.";
    public static final String RANDOM_NUMBER_IS_DUPLICATED = "[ERROR] 중복된 숫자가 생성되는 오류가 발생했습니다.";
    public static final String RETRY_IS_NOT_MATCHED = "[ERROR] 1 또는 2로 입력해야합니다.";
    public static final String BALL_NUMBER_IS_NOT_NUMBER = "[ERROR] 올바른 숫자를 입력해주세요.";
    public static final String BALL_NUMBER_SIZE_IS_NOT_MATCHED = "[ERROR] 3자리의 숫자를 입력해주세요.";
    public static final String BALL_NUMBER_IS_DUPLICATED = "[ERROR] 중복되지 않는 3자리의 숫자를 입력해주세요.";

    private ErrorMessage() {
    }
}
