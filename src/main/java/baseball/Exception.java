package baseball;

import java.util.HashSet;

public class Exception {
    private static final int RESTART_NUMBER = 1;
    private static final int EXIT_NUMBER = 2;
    private static final int NUMBER_LENGTH = 3;

    public static void validateOneOrTwo(int userInput) {
        if (userInput != RESTART_NUMBER && userInput != EXIT_NUMBER) {
            throw new IllegalArgumentException("1 또는 2 이외의 숫자는 입력할 수 없습니다. 프로그램 종료");
        }
    }

    public static void validateInput(char[] userInput) {
        validateDigits(userInput);
        validateLength(userInput);
        validateDuplicateNumbers(userInput);
    }

    public static void validateDigits(char[] userInput) {
        for (char c : userInput) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자 이외의 문자는 입력할 수 없습니다. 프로그램 종료");
            }
        }
    }

    public static void validateLength(char[] userInput) {
        if (userInput.length != NUMBER_LENGTH) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해야 합니다. 프로그램 종료");
        }
    }

    public static void validateDuplicateNumbers(char[] userInput) {
        HashSet<Character> inputSet = new HashSet<>();
        for (char c : userInput) {
            inputSet.add(c);
        }

        if (inputSet.size() != userInput.length) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다. 프로그램 종료");
        }
    }
}
