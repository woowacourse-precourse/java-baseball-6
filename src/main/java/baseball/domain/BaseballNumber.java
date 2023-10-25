package baseball.domain;

import static baseball.domain.BaseballNumberConstants.BASEBALL_NUMBER_LEN;
import static baseball.domain.BaseballNumberConstants.BASEBALL_MAX_NUMBER;
import static baseball.domain.BaseballNumberConstants.BASEBALL_MIN_NUMBER;

import java.util.List;
import java.util.stream.IntStream;

public class BaseballNumber {

    static final String NOT_VALID_LENGTH_MESSAGE = "3자리 숫자를 입력해주세요";
    static final String BELOW_RANGE_MESSAGE = "1 이상의 숫자를 입력해주세요";
    static final String OVER_RANGE_MESSAGE = "9 이하의 숫자를 입력해주세요";
    static final String NOT_UNIQUE_MESSAGE = "중복 되지 않은 숫자를 입력해주세요";

    private final List<Integer> numbers;

    public BaseballNumber(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    private void validate() {
        if (isNotValidLength()) {
            throw new IllegalArgumentException(NOT_VALID_LENGTH_MESSAGE);
        }
        if (isBelowRange()) {
            throw new IllegalArgumentException(BELOW_RANGE_MESSAGE);
        }
        if (isOverRange()) {
            throw new IllegalArgumentException(OVER_RANGE_MESSAGE);
        }
        if (isNotUnique()) {
            throw new IllegalArgumentException(NOT_UNIQUE_MESSAGE);
        }

    }

    private boolean isNotValidLength() {
        return numbers.size() != BASEBALL_NUMBER_LEN;
    }

    private boolean isBelowRange() {
        return numbers.stream()
                .anyMatch(it -> it < BASEBALL_MIN_NUMBER);
    }

    private boolean isOverRange() {
        return numbers.stream()
                .anyMatch(it -> it > BASEBALL_MAX_NUMBER);
    }

    private boolean isNotUnique() {
        return numbers.stream()
                .distinct()
                .count() != BASEBALL_NUMBER_LEN;
    }

    public GameResultDTO calculationGameResult(BaseballNumber other) {
        int strikeCount = calculationStrikeCount(other);
        int ballCount = calculationBallCount(other, strikeCount);
        return new GameResultDTO(ballCount, strikeCount);
    }

    private int calculationStrikeCount(BaseballNumber other) {
        return (int) IntStream.range(0, BASEBALL_NUMBER_LEN)
                .filter(index -> equals(index, other.numbers.get(index)))
                .count();

    }

    private boolean equals(int index, int key) {
        return numbers.get(index) == key;
    }

    private int calculationBallCount(BaseballNumber other, int strikeCount) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count() - strikeCount;
    }
}
