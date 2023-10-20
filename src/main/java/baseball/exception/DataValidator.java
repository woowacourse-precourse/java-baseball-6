package baseball.exception;

public class DataValidator {
    private static final int MAX_BALL_SIZE = 3;

    public void validateInputNumber(String data) {
        if (data.length() != MAX_BALL_SIZE) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
        for (int i = 0; i < data.length(); i++) {
            if (!Character.isDigit(data.charAt(i))) {
                throw new IllegalArgumentException("숫자만 입력해주세요");
            }
        }
    }
}
