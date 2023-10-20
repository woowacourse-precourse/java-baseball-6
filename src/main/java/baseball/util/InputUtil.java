package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    private static String readLine() {
        String input = Console.readLine().trim();
        validateHasInput(input);
        return input;
    }

    private static void validateHasInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(); // TODO 커스텀 예외 만들기
        }
    }
}
