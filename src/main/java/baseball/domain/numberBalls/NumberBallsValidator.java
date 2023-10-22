package baseball.domain.numberBalls;

import static baseball.domain.numberBalls.NumberBallsConstant.MAX_NUMBER;
import static baseball.domain.numberBalls.NumberBallsConstant.MIN_NUMBER;
import static baseball.domain.numberBalls.NumberBallsConstant.NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;

public class NumberBallsValidator {

    private NumberBallsValidator() {
    }

    public static NumberBallsValidator create() {
        return new NumberBallsValidator();
    }

    public void validateNumberSize(List<Integer> numberList) {
        if (numberList.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 숫자 수량이 잘못되었습니다.");
        }
    }

    public void validateNumberRange(List<Integer> numberList) {
        boolean isInvalid = numberList.stream()
                .anyMatch(this::isInvalidRange);

        if (isInvalid) {
            throw new IllegalArgumentException("[ERROR] 범위가 잘못되었습니다.");
        }
    }

    private boolean isInvalidRange(Integer number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public void validateDuplicateNumber(List<Integer> numberList) {
        if (numberList.size() != new HashSet<>(numberList).size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

}
