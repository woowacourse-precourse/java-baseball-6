package baseball.domain;

import java.util.List;

public class BallCountCalculator {
    public static int calculateBallCount(List<Integer> playerNumbers, List<Integer> randomNumbers) {
        return (int) playerNumbers.stream()
                .filter(number -> randomNumbers.contains(number) && !playerNumbers.get(randomNumbers.indexOf(number)).equals(number))
                .count();
    }

    public static int calculateStrikeCount(List<Integer> playerNumbers, List<Integer> randomNumbers) {
        return (int) playerNumbers.stream()
                .filter(number -> playerNumbers.indexOf(number) == randomNumbers.indexOf(number))
                .count();
    }
}
