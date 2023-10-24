package baseball.baseballV2.system.validator;

public class InputRestartNumberValidator {
    public static final String NOT_ONE_TWO_ERROR = "1과 2가 아닌 수를 입력했습니다";
    public static final String ONE_VALUE = "1";
    public static final String TWO_VALUE = "2";
    private final String inputNumber;

    public InputRestartNumberValidator(String restartNumber) {
        this.inputNumber = restartNumber;
        isOneOrTwo();
    }

    private void isOneOrTwo() {
        if ((!inputNumber.equals(ONE_VALUE)) && (!inputNumber.equals(TWO_VALUE))) {
            throw new IllegalArgumentException(NOT_ONE_TWO_ERROR);
        }
    }
}
