package baseball.util;

import java.util.HashSet;

public class InputManager {
    static final String RESTART = "1";
    static final String EXIT = "2";

    // 입력받은 값이 모두 숫자로 이루어져 있는지
    public static void isAllDigits(String userInput, int size) {
        for (char value : userInput.toCharArray()) {
            if (!Character.isDigit(value)) {
                throw new IllegalArgumentException(size + "자리의 수를 입력해주세요.");
            }
        }
    }

    // 입력받은 값이 모두 숫자일 때, min부터 max까지에 해당하는 수인지
    public static void isNumberInRange(String userInput, int min, int max) {
        for (char digit : userInput.toCharArray()) {
            int number = Integer.parseInt(String.valueOf(digit));
            if (number < min || max < number) {
                throw new IllegalArgumentException(min + "~" + max + "에 해당하는 수만 입력해주세요.");
            }
        }
    }

    // 입력받은 값이 주어진 size에 맞는지
    public static void isSizeValid(String userInput, int size) {
        if (userInput.length() != size) {
            throw new IllegalArgumentException(size + "자리의 수를 입력해주세요.");
        }
    }

    // 입력받은 값에 중복된 수가 있는지
    public static void hasDuplicates(String userInput, int size) {
        HashSet<Character> uniqueDigits = new HashSet<>();
        for (int i = 0; i < size; i++) {
            char digit = userInput.charAt(i);
            if (!uniqueDigits.add(digit)) {
                throw new IllegalArgumentException("수를 중복되지 않게 입력해주세요.");
            }
        }
    }

    // 게임 종료 시 재시작 여부를 묻는 과정에서 수가 아닌 값이 입력되었는지
    public static void isRestartInputDigit(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 " + RESTART + " 혹은 " + EXIT + "를 입력해주세요.");
        }
    }

    // 게임 종료 시 재시작 여부를 묻는 과정에서 RESTART, EXIT 외의 수가 입력되었는지
    public static void isRestartInputValidNumber(String userInput) {
        if (!userInput.equals(RESTART) && !userInput.equals(EXIT)) {
            throw new IllegalArgumentException(RESTART + " 혹은 " + EXIT + "를 입력해주세요.");
        }
    }
}
