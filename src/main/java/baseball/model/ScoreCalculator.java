package baseball.model;

import java.util.List;
import java.util.stream.IntStream;

public class ScoreCalculator {

    public Integer calculateStrike(List<Integer> playerInput, List<Integer> answer) {
        return (int) IntStream.range(0, answer.size())
                .filter(index -> playerInput.get(index)
                        .equals(answer.get(index)))
                .count();
    }
}
