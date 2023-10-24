package Manager;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class InputManager {
    public static int getInt() {
        return Integer.parseInt(Console.readLine());
    }

    public static String getString() {
        return Console.readLine();
    }

    public static List<Integer> parseInput(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
