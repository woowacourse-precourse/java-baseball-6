package baseball.domain;

import java.util.List;

public class Numbers {

    public static final Integer MAX_NUMBER = 9;
    public static final Integer MIN_NUMBER = 1;
    public static final Integer NUMBER_COUNT = 3;
    private final List<Integer> numberList;

    public Numbers(List<Integer> numberList) {
        validateNumberSize(numberList);
        validateNumberRange(numberList);
        this.numberList = numberList;
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

    public List<Integer> getNumberList() {
        return numberList;
    }

}
