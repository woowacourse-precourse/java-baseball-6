package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerNumbers;

    public Player(String input) {
        this.playerNumbers = generatePlayerNumbers(input);
    }

    private List<Integer> generatePlayerNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for(char number : input.toCharArray()) {
            numbers.add(number - '0');
        }
        return numbers;
    }
}
