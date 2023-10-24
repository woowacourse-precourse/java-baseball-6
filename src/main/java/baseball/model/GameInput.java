package baseball.model;

import baseball.BaseballGame;

import java.util.*;

public class GameInput {

    private final List<Integer> numbers;

    public GameInput(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static GameInput from(String[] input) {
        List<Integer> numberList = new ArrayList<>();
        for (String s : input) {
            int n;
            try {
                n = Integer.parseInt(s);
                if (n < BaseballGame.NUMBER_RANGE_START || n > BaseballGame.NUMBER_RANGE_END || numberList.contains(n)) {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException();
            }
            numberList.add(n);
        }

        return new GameInput(numberList);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
