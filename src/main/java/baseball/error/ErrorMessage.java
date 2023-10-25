package baseball.error;

// TODO: Enum class로 관리하는 것도 고려
public class ErrorMessage {

    public static final String INVALID_NUMBER_INPUT = "숫자만 입력할 수 있습니다.";
    public static final String INVALID_INPUT_SIZE = "입력값의 자릿수가 잘못되었습니다. 세 자리 숫자를 입력하세요.";
    public static final String INVALID_INPUT_NUMBER_RANGE = "허용되지 않는 범위의 숫자입니다. 각 숫자는 1~9 범위의 숫자만 입력 가능합니다.";
    public static final String DUPLICATE_NUMBER = "중복된 숫자는 입력할 수 없습니다.";
}
