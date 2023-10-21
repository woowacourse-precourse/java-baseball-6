package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtil {

    public static List<Integer> readIntegerList() {
        return stringToIntegerList(readLine());
    }

    private static List<Integer> stringToIntegerList(String input) {
        validateInteger(input);
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    public static int readInt() {
        String input = readLine();
        validateInteger(input);
        return Integer.parseInt(input);
    }

    private static void validateInteger(String input) {
        if (input.chars().anyMatch(c -> !Character.isDigit(c))) {
            throw new IllegalArgumentException();
        }
    }

    private static String readLine() {
        String input = Console.readLine().trim();
        validateHasInput(input);
        return input;
    }

    private static void validateHasInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
