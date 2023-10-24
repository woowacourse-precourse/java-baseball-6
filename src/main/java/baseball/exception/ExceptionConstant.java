package baseball.exception;

public class ExceptionConstant {
    public static final String DUPLICATION_NUMBER_EXCEPTION = "중복된 수가 있습니다.";
    public static final String NOT_NUMBER_EXCEPTION = "숫자만 입력해주세요";
    public static final String OVER_LENGTH_LIMIT = "3자리 이상 입력하셨습니다. 3자리로 입력해주세요.";
    public static final String UNDER_LENGTH_LIMIT = "3자리 이하로 입력하셨습니다. 3자리로 입력해주세요";
    public static final String NOT_RESTART_AND_FINISH = "다시 시작하고 싶으면 1, 끝내고 싶으면 2를 입력해주세요";

    private ExceptionConstant() {
    }
}
