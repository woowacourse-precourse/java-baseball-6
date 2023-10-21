package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.util.ErrorMessage.*;

public record GameNumber(List<Integer> number) {

    public GameNumber {
        checkNumber(number);
    }

    private void checkNumber(List<Integer> number) {
        checkLength(number);
        checkDuplicate(number);
        checkZero(number);
        checkNegative(number);
    }

    public int getNumberOfIndex(int index) {
        return this.number.get(index);
    }

    public boolean isContain(int indexNumber) {
        return this.number.contains(indexNumber);
    }

    public boolean isInPlace(int index, int indexNumber) {
        return this.number.get(index).equals(indexNumber);
    }

    private void checkLength(List<Integer> number) {
        if (number.size() != 3) {
            throw new IllegalArgumentException(LENGTH_ERROR);
        }
    }

    private void checkDuplicate(List<Integer> number) {
        Set<Integer> set = new HashSet<>(number);
        if (set.size() != number.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private void checkZero(List<Integer> number) {
        if (number.contains(0)) {
            throw new IllegalArgumentException(ZERO_ERROR);
        }
    }

    private void checkNegative(List<Integer> number) {
        for (Integer i : number) {
            if (i < 0) {
                throw new IllegalArgumentException(NEGATIVE_ERROR);
            }
        }
    }
}
