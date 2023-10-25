package baseball;

import java.util.Arrays;

public class GameException {
    public static boolean isInRange(String input) {
        return input != null && input.matches("[1-9]+");
    }

    public static boolean isNotDuplicate(String input) {
        return Arrays.stream(input.split(""))
                .distinct()
                .count() == 3;
    }
}
