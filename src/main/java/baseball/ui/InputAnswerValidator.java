package baseball.ui;

public class InputAnswerValidator implements InputValidator {

    public String check(String input) {
        checkSizeValid(input, 3);
        return input;
    }

    @Override
    public String validateInput(String input) {
        checkSizeValid(input, 3);
        if (isNumeric(input)) {
            return input;
        }
        throw new IllegalArgumentException(String.format("입력은 3 자리 정수값이어야합니다. 입력하신 값 : %s", input));
    }

}
