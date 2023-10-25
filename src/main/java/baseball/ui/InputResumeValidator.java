package baseball.ui;

public class InputResumeValidator implements InputValidator {

    public String check(String input) {
        checkSizeValid(input, 1);
        return input;
    }

    @Override
    public String validateInput(String input) {
        checkSizeValid(input, 1);
        if (input.contentEquals("1") || input.contentEquals("2")) {
            return input;
        }
        throw new IllegalArgumentException(String.format("입력은 1 혹은 2의 값이어야합니다. 입력하신 값 : %s", input));
    }

}
