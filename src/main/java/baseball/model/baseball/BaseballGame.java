package baseball.model.baseball;

import baseball.constants.BaseballRole;
import baseball.util.RandomNumberCreateUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class BaseballGame {

    private final List<Integer> baseballNumbers;

    public BaseballGame() {
        this.baseballNumbers = RandomNumberCreateUtil.createBaseballNumbers();
    }

    public long compareBallCount(List<Integer> expectedNumbers) {
        return IntStream.range(0, BaseballRole.MAX_BASEBALL_NUMBER_SIZE.getValue())
                .filter(i -> !Objects.equals(baseballNumbers.get(i), expectedNumbers.get(i)))
                .filter(i -> baseballNumbers.contains(expectedNumbers.get(i)))
                .count();
    }

    public long compareStrikeCount(List<Integer> expectedNumbers) {
        return IntStream.range(0, BaseballRole.MAX_BASEBALL_NUMBER_SIZE.getValue())
                .filter(i -> Objects.equals(baseballNumbers.get(i), expectedNumbers.get(i)))
                .count();

    }

}
