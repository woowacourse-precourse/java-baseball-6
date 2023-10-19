package baseball.domain;

import baseball.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int CAPACITY = 3;
    private static final String ILLEGAL_RANGE = "시스템 내부에서 잘못된 값이 입력되었습니다.";

    private final List<Integer> baseBallNumbers = new ArrayList<>();

    private boolean isContainNumber(int number) {
        if (baseBallNumbers.contains(number)) return true;
        else return false;
    }

    public Baseball generateBaseballs() {
        if (!baseBallNumbers.isEmpty()) baseBallNumbers.clear();

        while (baseBallNumbers.size() != CAPACITY) {
            int candidate = RandomGenerator.generateNumber();
            validateRange(candidate);
            validateDuplication(candidate);
        }
        return this;
    }

    private void validateRange(int candidate) {
        if (MINIMUM_NUMBER > candidate && MAXIMUM_NUMBER < candidate)
            throw new IllegalArgumentException(ILLEGAL_RANGE);
    }

    private void validateDuplication(int candidate) {
        if (!isContainNumber(candidate))
            baseBallNumbers.add(candidate);
    }

    public List<Integer> getBaseBallNumbers() {
        return baseBallNumbers;
    }

}
