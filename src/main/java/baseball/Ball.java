package baseball;

public class Ball {

    private static final int UNDER_RANGE = 1;

    public Ball(int i) {

    }

    public void validateRange(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException("입력은 0을 포함할 수 없슴니다.");
        }
    }

    private boolean isInRange(int number) {
        return number >= UNDER_RANGE;
    }

//    private static final String NUMBER_FORMAT = "\\d+";
//    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "올바른 숫자를 입력해주세요.";


//    public void validateForm(String rawNumber) {
//        if (!isNumber(rawNumber)) {
//            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
//        };
//    }
//
//    private boolean isNumber(String rawNumber) {
//        return rawNumber.matches(NUMBER_FORMAT);
//    }
}
