package baseball.domain;

import java.util.List;

public class BaseBallNumberList {

    private final List<Integer> numbers;
    private static final int BASE_BALL_NUMBERS_SIZE = 3;

    public BaseBallNumberList(List<Integer> numbers) {
        this.numbers = numbers;
        validateSize();
        validateSameItem();
        validateRange();
    }

    public int countSameNumber(BaseBallNumberList baseBallNumberList) {
        return (int) baseBallNumberList.numbers.stream()
                .filter(o -> numbers.stream().anyMatch(o::equals)).count();
    }

    public boolean equalAt(int index, BaseBallNumberList baseBallNumberList) {
        return this.numbers.get(index).equals(baseBallNumberList.numbers.get(index));
    }

    public int size() {
        return BASE_BALL_NUMBERS_SIZE;
    }

    private void validateRange() {
        int min = 1;
        int max = 9;
        if (notInRange(min, max)) {
            throw new IllegalArgumentException("1~9 사이 숫자만 사용해 주세요");
        }
    }

    private boolean notInRange(int min, int max) {
        return numbers.stream().anyMatch((i) -> i < min || max < i);
    }

    private void validateSameItem() {
        if (haveSameItem()) {
            throw new IllegalArgumentException("중복된 값을 입력하지 말아 주세요");
        }
    }

    private void validateSize() {
        if (haveThreeItems()) {
            throw new IllegalArgumentException("숫자를 3개를 입력해주세요");
        }
    }

    private boolean haveThreeItems() {
        return this.numbers.size() != BASE_BALL_NUMBERS_SIZE;
    }

    private boolean haveSameItem() {
        return this.numbers.stream().distinct().count() != this.numbers.size();
    }
}
