package validation;

public class ValidationStatus {
    private static final String STATUS_INPUT_ERROR_MESSAGE = "숫자 1(재실행) 또는 2(종료)만 입력해주세요.";
    public static void ValidationStatus(int status) {
        if (status < 1 || status > 2) {
            throw new IllegalArgumentException(STATUS_INPUT_ERROR_MESSAGE);
        }
    }
}
