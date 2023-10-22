package baseball.controller;

public class UserInputValidator {
    private static final String NULL_INPUT_MESSAGE = "null은 입력할 수 없습니다.";

    public String userInputStringValidate(String userInputString) {
        if (userInputString == null) {
            throw new IllegalArgumentException(NULL_INPUT_MESSAGE);
        }
        return userInputString.replaceAll(" ", "");
    }
}
