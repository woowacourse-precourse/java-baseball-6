package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerNumbers;

    private Player(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public static Player from(String input) {
        validateNotZero(input);
        validateNumberSize(input);
        List<Integer> numbers = new ArrayList<>();
        for (char num : input.toCharArray()) {
            validateIsNumber(num);
            int number = num - '0';
            validateRedundantNumber(numbers, number);
            numbers.add(number);
        }
        return new Player(numbers);
    }

    private static void validateNotZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumberSize(String input) {
        if (input.length() != Constants.NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRedundantNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsNumber(char input) {
        if (!Character.isDigit(input)) {
            throw new IllegalArgumentException();
        }
    }
}
