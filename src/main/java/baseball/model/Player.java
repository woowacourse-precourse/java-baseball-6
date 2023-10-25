package baseball.model;

import java.util.List;

public class Player {
    private final Numbers numbers;

    public Player(Numbers numbers) {
        this.numbers = numbers;
    }

    public static Player generatePlayerAsInput(String playerInput) {
        return new Player(Numbers.createPlayerNumbersFromInput(playerInput));
    }

    public List<Integer> getNumbers() {
        return this.numbers.getNumbers();
    }
}
