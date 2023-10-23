package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Result {
    private Integer strike;
    private Integer ball;

    public Result(List<Integer> computerNumbers, List<Integer> userNumbers) {
        this.strike = checkStrike(computerNumbers, userNumbers);
        this.ball = ball;
    }

    private Integer checkStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        return (int) IntStream.range(0, userNumbers.size())
                .filter(i -> userNumbers.get(i).equals(computerNumbers.get(i)))
                .count();
    }
}
