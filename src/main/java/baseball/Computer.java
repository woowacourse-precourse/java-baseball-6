package baseball;

import java.util.stream.IntStream;

public class Computer {

    private final BaseballNumbers numbers;

    public Computer() {
        this.numbers = RandomNumberFactory.createRandomNumbers();
    }

    public GameResult guess(BaseballNumbers userNumbers) {
        int strikes = calculateStrikes(userNumbers);
        int balls = calculateBalls(userNumbers) - strikes;
        return new GameResult(strikes, balls);
    }

    private int calculateStrikes(BaseballNumbers userNumbers) {
        return (int) IntStream.range(0, 3)
                .filter(i -> numbers.getNumberAt(i).isSameValue(userNumbers.getNumberAt(i)))
                .count();
    }

    private int calculateBalls(BaseballNumbers userNumbers) {
        return (int) IntStream.range(0, 3)
                .filter(i -> IntStream.range(0, 3)
                        .anyMatch(j -> numbers.getNumberAt(i).isSameValue(userNumbers.getNumberAt(j))))
                .count();
    }
}
