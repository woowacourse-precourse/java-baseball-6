package baseball.domain;

import java.util.List;

public class Game {
    private List<Integer> randomNumbers;

    private Game(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public static Game numberOf(List<Integer> randomNumbers) {
        return new Game(randomNumbers);
    }
}
