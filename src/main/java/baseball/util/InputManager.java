package baseball.util;

import java.util.HashSet;

public class InputManager {
    static final int RESTART = 1;
    static final int EXIT = 2;

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

    // 게임 종료 시 재시작 여부를 묻는 과정에서 RESTART, EXIT 외의 수가 입력되었는지
    public static boolean isRestartInputValid(int userInput) {
        return userInput == RESTART || userInput == EXIT;
    }
}
