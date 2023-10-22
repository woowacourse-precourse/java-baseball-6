package baseball;

import java.util.List;

public class Player {

    private Numbers numbers;

    public List<Integer> getPlayerNumbers() {
        return List.copyOf(numbers.getList());
    }

    public void guessNumber(String input) {
        numbers = new Numbers(input);
    }
}
