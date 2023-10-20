package baseball;

import baseball.io.Randoms;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WinningNumbers {

    public static final int MAX_SIZE = 3;

    List<Integer> winningNumbers;

    public WinningNumbers() {
        this.winningNumbers = Stream.generate(Randoms::getSingleNumber)
                .distinct()
                .limit(MAX_SIZE)
                .toList();
    }

    public BallCount ballCounting(BaseballNumbers baseballNumbers) {
        long countOfOnlyContains = baseballNumbers.get().stream()
                .filter(winningNumbers::contains)
                .count();
        long countOfExactMatches = IntStream.range(0, 3)
                .filter(i -> Objects.equals(
                        winningNumbers.get(i), baseballNumbers.get().get(i)))
                .count();
        long countOfBall = countOfOnlyContains - countOfExactMatches;
        long countOfStrike = countOfExactMatches;
        return new BallCount(countOfStrike, countOfBall);
    }
}
