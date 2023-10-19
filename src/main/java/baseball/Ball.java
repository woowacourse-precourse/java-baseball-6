package baseball;

public class Ball {

    private static final String NUMBER_FORMAT = "\\d+";
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "올바른 숫자를 입력해주세요.";

    public static Ball from() {
        return new Ball();
    }

    public void validateForm(String rawNumber) {
        if (!isNumber(rawNumber)) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        };
    }

    private boolean isNumber(String rawNumber) {
        return rawNumber.matches(NUMBER_FORMAT);
    }
}
