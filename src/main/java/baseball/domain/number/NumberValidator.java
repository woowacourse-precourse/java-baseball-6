package baseball.domain.number;

import static baseball.domain.number.NumberConstant.MAX_NUMBER;
import static baseball.domain.number.NumberConstant.MIN_NUMBER;
import static baseball.domain.number.NumberConstant.NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;

public class NumberValidator {
    public static void validateNumberSize(List<Integer> numberList) {
        if (numberList.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 숫자 수량이 잘못되었습니다.");
        }
    }

    public static void validateNumberRange(List<Integer> numberList) {
        boolean isInvalid = numberList.stream()
                .anyMatch(NumberValidator::isInvalidRange);

        if (isInvalid) {
            throw new IllegalArgumentException("[ERROR] 범위가 잘못되었습니다.");
        }
    }

    private static boolean isInvalidRange(Integer number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public static void validateDuplicateNumber(List<Integer> numberList) {
        if (numberList.size() != new HashSet<>(numberList).size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private NumberValidator() {
    }

}
