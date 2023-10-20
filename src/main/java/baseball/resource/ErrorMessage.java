package baseball.resource;

public final class ErrorMessage {

    public static final String NUMBER_ERROR_MESSAGE = "입력받은 값이 숫자가 아닙니다.";
    public static final String LENGTH_ERROR_MESSAGE = "개의 숫자만 입력해주세요.";
    public static final String SCOPE_NUMBER_ERROR_MESSAGE = "각 숫자의 범위는 "
                                                            + GameValue.MIN_NUMBER + "부터 "
                                                            + GameValue.MAX_NUMBER + "까지만 가능합니다.";
    public static final String DUPLICATE_ERROR_MESSAGE = "중복된 숫자는 입력할 수 없습니다.";
    public static final String RESTART_ERROR_MESSAGE = "새로 시작은 1, 종료는 2만 입력 가능합니다.";
}
