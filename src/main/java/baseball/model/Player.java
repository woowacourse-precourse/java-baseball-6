package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static baseball.rules.GameConstants.NUMBER_OF_DIGITS;

public class Player {
    private final List<Integer> numbers;

    public Player() {
        this.numbers = new ArrayList<>(NUMBER_OF_DIGITS);
    }

    public void inputNumbers(String input) {
        this.numbers.clear();

        for (String number : input.split("")) {
            this.numbers.add(Integer.parseInt(number));
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
