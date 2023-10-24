package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class AnswerChecker {
    public GameResult calculateGameResult(List<Integer> answer, List<Integer> input) {
        return new GameResult(calculateStrikes(answer, input), calculateBalls(answer, input));
    }

    private int calculateStrikes(List<Integer> answer, List<Integer> input) {
        return (int) IntStream.range(0, answer.size())
                .filter(i -> input.get(i) == answer.get(i))
                .count();
    }

    private int calculateBalls(List<Integer> answer, List<Integer> input) {
        return (int) IntStream.range(0, answer.size())
                .filter(i -> input.get(i) != answer.get(i) && answer.contains(input.get(i)))
                .count();
    }
}
