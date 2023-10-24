package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class UserNumberInput {
    public static List<Integer> input() {
        String input = readInput();
        return parse(input);
    }

    // string input -> list of integers
    // 123 -> [1, 2, 3]
    // 1234 -> IllegalArgumentException
    private static List<Integer> parse(String input) {
        if (InputCheck.check(input) == false) {
            throw new IllegalArgumentException("Input length must be 3");
        }
        return List.of(
                Integer.parseInt(String.valueOf(input.charAt(0))),
                Integer.parseInt(String.valueOf(input.charAt(1))),
                Integer.parseInt(String.valueOf(input.charAt(2)))
        );
    }


    private static String readInput() {
        return readLine();
    }
}
