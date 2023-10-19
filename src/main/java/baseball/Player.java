package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerNumbers;

    public Player(String input) {
        this.playerNumbers = generatePlayerNumbers(input);
    }

    private List<Integer> generatePlayerNumbers(String input) {
        validateNotZero(input);
        validateNumberDigit(input);
        List<Integer> numbers = new ArrayList<>();
        for (char number : input.toCharArray()) {
            numbers.add(number - '0');
        }
        return numbers;
    }

    private void validateNotZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberDigit(String input) {
        if(input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
