package baseball.model;

import java.util.List;
import java.util.stream.IntStream;

public class Score {
    int strikes;
    int balls;

    public Score(List<Integer> randomNumbers, List<Integer> userInput) {
        this.strikes = (int) IntStream.range(0, 3)
                .filter(i -> userInput.get(i).equals(randomNumbers.get(i)))
                .count();

        this.balls = (int) IntStream.range(0, 3)
                .filter(i -> !userInput.get(i).equals((randomNumbers.get(i)))
                        && userInput.contains(randomNumbers.get(i)))
                .count();
    }

    public int getStrike() {
        return strikes;
    }

    public int getBall() {
        return balls;
    }
}
