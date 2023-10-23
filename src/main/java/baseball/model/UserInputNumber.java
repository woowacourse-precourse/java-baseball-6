package baseball.model;

public class UserInputNumber {
    String userInput;

    public UserInputNumber(String userInput) {
        checkTypeNumber(userInput);
        checkThreeNumber(userInput);
        this.userInput = userInput;
    }

    public String getUserInputNumber() {return userInput;}

    public static void checkThreeNumber(String userInput) throws IllegalArgumentException {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자로 입력해주세요.");
        }
    }

    public static void checkTypeNumber(String userInput) throws IllegalArgumentException {
        if (!userInput.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");

        }
    }

}
