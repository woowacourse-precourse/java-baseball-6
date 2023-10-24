package baseball;

import java.util.List;

public class ExceptionHandler {
    static void checkInputSize(String input, int size) {
        if (input.length() != size) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    static void checkNumber(int number, List<Integer> player) {
        if (number < 1 || number > 9 || player.contains(number)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    static void checkCommand(char command) {
        if (command != '1' && command != '2') {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
