package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Grader {

    private final List<Integer> answer;

    public Grader(List<Integer> answer) {
        this.answer = answer;
    }

    public ScoreBoard grade(List<Integer> playerNumbers) {
        validatePlayerNumbersSize(playerNumbers);

        int ballCount = (int) IntStream.range(0, playerNumbers.size())
            .filter(index -> isContains(playerNumbers, index))
            .filter(index -> isNotStrike(playerNumbers, index))
            .count();

        int strikeCount = (int) IntStream.range(0, playerNumbers.size())
            .filter(index -> isStrike(playerNumbers, index))
            .count();

        return new ScoreBoard(ballCount, strikeCount);
    }

    private boolean isStrike(List<Integer> playerNumbers, int index) {
        return answer.get(index).equals(playerNumbers.get(index));
    }

    private boolean isNotStrike(List<Integer> playerNumbers, int index) {
        return !answer.get(index).equals(playerNumbers.get(index));
    }

    private boolean isContains(List<Integer> playerNumbers, Integer index) {
        return answer.contains(playerNumbers.get(index));
    }

    private void validatePlayerNumbersSize(List<Integer> playerNumbers) {
        if (playerNumbers.size() > answer.size()) {
            throw new IllegalArgumentException();
        }
    }
}
