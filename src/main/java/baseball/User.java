package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final int NUMBER_LENGTH = 3;
    private static final String OUTPUT_ENTER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String EXCEPTION_MESSAGE = "Please enter a three-digit natural number consisting of 1 to 9.";
    int userNumber;

    public User() {}

    public void setUserNumber() {
        System.out.print(OUTPUT_ENTER_NUMBER);
        String input = inputUserNumber();
        validateInput(input);
        this.userNumber = Integer.parseInt(input);
    }

    // method only for test code
    public void setUserNumber(String input) {
        validateInput(input);
        this.userNumber = Integer.parseInt(input);
    }

    public int getUserNumber() {
        return userNumber;
    }

    private static String inputUserNumber() {
        return Console.readLine();
    }

    private void validateInput(String input) {
        validateInputLength(input);
        validateInputDigits(input);
    }

    private void validateInputDigits(String input) {
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }

    private static void validateInputLength(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}
