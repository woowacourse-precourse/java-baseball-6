package validation;

public class ValidationStatus {
    private static final String STATUS_INPUT_ERROR_MESSAGE = "1또는 2만 입력해주세요.";
    public static void ValidationStatus(int status) {
        if (status < 1 || status > 2) {
            throw new IllegalArgumentException(STATUS_INPUT_ERROR_MESSAGE);
        }
    }
}
