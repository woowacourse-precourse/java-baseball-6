package baseball.gameutil.calculator;

import baseball.gameutil.Score;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class ScoreCalculatorBaseBall implements ScoreCalculator {

    @Override
    public Score calScore(List<Integer> userInput, List<Integer> computerInput) {
        return new Score(
            calBall(userInput, computerInput),
            calStrike(userInput, computerInput)
        );
    }

    private int calStrike(List<Integer> userInput, List<Integer> computerInput) {
        return (int) IntStream.range(0, userInput.size())
            .filter(idx -> userInput.get(idx) == computerInput.get(idx))
            .count();
    }

    private int calBall(List<Integer> userInput, List<Integer> computerInput) {
        Set<Integer> computerInputSet = new HashSet<>(computerInput);
        return (int) IntStream.range(0, userInput.size())
            .filter(idx -> userInput.get(idx) != computerInput.get(idx))
            .filter(idx -> computerInputSet.contains(userInput.get(idx)))
            .count();
    }
}
