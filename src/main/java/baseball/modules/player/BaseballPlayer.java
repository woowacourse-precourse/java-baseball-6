package baseball.modules.player;

import static baseball.modules.score.BaseBallScoreType.*;
import static baseball.utils.BaseballNumberConstants.END_RANGE;
import static baseball.utils.BaseballNumberConstants.MAX_BASEBALL_NUMBER_SIZE;
import static baseball.utils.BaseballNumberConstants.START_RANGE;
import static java.util.Arrays.stream;

import baseball.modules.score.BaseBallScoreType;
import baseball.modules.score.ScoreType;
import baseball.utils.ListUtils;
import baseball.utils.NumberUtils;
import baseball.utils.StringUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class BaseballPlayer implements Player{

    private final List<Integer> numbers;

    public BaseballPlayer(final String numbers) {
        validateBaseBallNumber(numbers);
        this.numbers = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).boxed().toList();
    }

    public BaseballPlayer(final List<Integer> numbers) {
        if (!ListUtils.isLengthEqual(numbers, MAX_BASEBALL_NUMBER_SIZE.getConstant())) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    private void validateBaseBallNumber(final String numbers) {
        if (!StringUtils.isLengthEqual(numbers, MAX_BASEBALL_NUMBER_SIZE.getConstant()))
            throw new IllegalArgumentException();

        if (StringUtils.hasDuplicate(numbers))
            throw new IllegalArgumentException();

        if (!StringUtils.isNumeric(numbers))
            throw new IllegalArgumentException();

        if (stream(numbers.split(""))
                .map(Integer::parseInt)
                .anyMatch(value -> !NumberUtils.isWithInRange(
                        value,
                        START_RANGE.getConstant(),
                        END_RANGE.getConstant()))
        ) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public Map<? extends ScoreType, Integer> compare(final Player player) {
        Map<BaseBallScoreType, Integer> score = getInitScore();

        final List<Integer> playerNumbers = player.getNumbers();
        for (int i = 0; i < this.numbers.size(); i++) {
            if (Objects.equals(this.numbers.get(i), playerNumbers.get(i))) {
                score.put(STRIKE, score.get(STRIKE) + 1);
                continue;
            }
            if (this.numbers.contains(playerNumbers.get(i))) {
                score.put(BALL, score.get(BALL) + 1);
            }
        }

        return score;
    }



    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseballPlayer that = (BaseballPlayer) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "BaseballPlayer{" +
                "numbers=" + numbers +
                '}';
    }
}
