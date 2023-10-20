package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputUtil {

    public static List<Integer> readIntegerList() {
        try {
            return readLine().chars()
                    .mapToObj(Character::getNumericValue)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(); // TODO 커스텀 예외 만들기
        }
    }

    public static int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(); // TODO 커스텀 예외 만들기
        }
    }

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
