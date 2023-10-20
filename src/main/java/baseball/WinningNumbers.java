package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WinningNumbers {

    List<Integer> winningNumbers;

    public WinningNumbers() {
        // TODO : 외부 라이브러리 의존성 제거
        this.winningNumbers = Stream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
    }

    public BallCount ballCounting(BaseballNumbers baseballNumbers) {
        long countOfOnlyContains = baseballNumbers.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        long countOfExactMatches = IntStream.range(0, 3)
                .filter(i -> Objects.equals(
                        winningNumbers.get(i), baseballNumbers.getNumbers().get(i)))
                .count();
        long countOfBall = countOfOnlyContains - countOfExactMatches;
        long countOfStrike = countOfExactMatches;
        return new BallCount(countOfStrike, countOfBall);
    }
}
