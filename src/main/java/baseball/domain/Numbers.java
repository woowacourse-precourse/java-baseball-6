package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Numbers {

    public static final Integer MAX_NUMBER = 9;
    public static final Integer MIN_NUMBER = 1;
    public static final Integer NUMBER_COUNT = 3;
    private final List<Integer> numberList;

    public Numbers(List<Integer> numberList) {
        validateNumberList(numberList);
        this.numberList = numberList;
    }

    private void validateNumberList(List<Integer> numberList) {
        validateNumberSize(numberList);
        validateNumberRange(numberList);
        validateDuplicateNumber(numberList);
    }

    private void validateNumberSize(List<Integer> numberList) {
        if (numberList.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 숫자 수량이 잘못되었습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numberList) {
        for (Integer number : numberList) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 범위가 잘못되었습니다.");
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numberList) {
        if (numberList.size() != new HashSet(numberList).size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

}
