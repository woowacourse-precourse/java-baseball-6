package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputDevice {
    private InputDevice() {
    }

    public static List<Integer> readPlayerNumbers() throws IllegalArgumentException {
        List<Integer> player = parseStringToInteger(Console.readLine());
        validateSize(player, 3);
        validateNumbersInRange(player, 9);
        validateduplication(player);
        return player;
    }

    public static int readNumber() throws IllegalArgumentException {
        List<Integer> player = parseStringToInteger(Console.readLine());
        validateSize(player, 1);
        validateNumbersInRange(player, 2);
        return player.get(0);
    }

    private static List<Integer> parseStringToInteger(String s) {
        List<Integer> result = new ArrayList<>();
        for (String t : s.split("")) {
            result.add(Integer.parseInt(t));
        }
        return result;
    }

    private static void validateSize(final List<Integer> numbers, final int n) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (numbers.size() != n) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumbersInRange(final List<Integer> numbers, final int endInclusive) {
        for (Integer n : numbers) {
            if (n < 1 || n > endInclusive) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateduplication(final List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
}
