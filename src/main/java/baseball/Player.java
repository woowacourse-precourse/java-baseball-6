package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerNumbers;

    public Player(String input) {
        this.playerNumbers = generatePlayerNumbers(input);
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    private List<Integer> generatePlayerNumbers(String input) {
        validateNotZero(input);
        validateNumberDigit(input);
        List<Integer> numbers = new ArrayList<>();
        for (char num : input.toCharArray()) {
            validateIsNumber(num);
            int number = num - '0';
            validateRedundantNumber(numbers, number);
            numbers.add(number);
        }
        return numbers;
    }

    private void validateNotZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberDigit(String input) {
        if (input.length() != Constants.NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRedundantNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIsNumber(char input) {
        if (!Character.isDigit(input)) {
            throw new IllegalArgumentException();
        }
    }
}
