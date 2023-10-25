package baseball.util;

import baseball.model.player.GuessNumber;
import java.util.List;
import java.util.stream.IntStream;

public class ScoreCalculator {

    private static final Integer FIRST_INDEX = 0;
    private static final Integer LAST_INDEX = 3;

    private ScoreCalculator() {
    }

    public static Integer calculateStrike(List<GuessNumber> playerInput, List<Integer> answer) {
        return (int) IntStream.range(FIRST_INDEX, LAST_INDEX)
                .filter(index -> isStrike(playerInput, answer, index))
                .count();
    }

    public static Integer calculateBall(List<GuessNumber> playerInput, List<Integer> answer) {
        return (int) IntStream.range(FIRST_INDEX, LAST_INDEX)
                .filter(index -> !isStrike(playerInput, answer, index) && isBall(playerInput, answer, index))
                .count();
    }

    private static boolean isStrike(List<GuessNumber> playerInput, List<Integer> answer, int index) {
        return playerInput.get(index).getNumber().equals(answer.get(index));
    }

    private static boolean isBall(List<GuessNumber> playerInput, List<Integer> answer, int index) {
        return answer.contains(playerInput.get(index).getNumber());
    }
}
