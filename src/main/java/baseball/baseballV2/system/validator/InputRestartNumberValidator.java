package baseball.baseballV2.system.validator;

public class InputRestartNumberValidator {
    private final String inputNumber;

    public InputRestartNumberValidator(String restartNumber) {
        this.inputNumber = restartNumber;
        isOneOrTwo();
    }

    private void isOneOrTwo() {
        if (!inputNumber.equals("1") && !inputNumber.equals("2")) {
            throw new IllegalArgumentException("1과 2가 아닌 수를 입력했습니다");
        }
    }
}
