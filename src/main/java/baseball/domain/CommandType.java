package baseball.domain;

import java.util.Arrays;
import java.util.List;

public enum CommandType {
    RESTART(1), QUIT(2);

    private final int number;

    CommandType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static List<Integer> getAllCommandNumbers() {
        return Arrays.stream(CommandType.values())
                .map(CommandType::getNumber)
                .toList();
    }
}