package baseball;

import baseball.io.Randoms;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WinningNumbers {

    List<Integer> winningNumbers;

    public WinningNumbers() {
        this.winningNumbers = Stream.generate(Randoms::getSingleNumber)
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
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
