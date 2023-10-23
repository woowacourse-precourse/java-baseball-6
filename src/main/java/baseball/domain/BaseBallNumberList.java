package baseball.domain;

import java.util.Collections;
import java.util.List;

public class BaseBallNumberList {

    private final List<Integer> numbers;

    public BaseBallNumberList(List<Integer> numbers) {
        this.numbers = numbers;
        validateSize();
        validateSameItem();
    }

    private void validateSameItem() {
        if (haveSameItem() || hasThreeItems()) {
            throw new IllegalArgumentException("중복된 값을 입력하지 말아 주세요");
        }
    }

    private void validateSize() {
        if (hasThreeItems()) {
            throw new IllegalArgumentException("숫자를 3개를 입력해주세요");
        }
    }

    private boolean hasThreeItems() {
        return this.numbers.size() != 3;
    }

    private boolean haveSameItem() {
        return this.numbers.stream().distinct().count() != this.numbers.size();
    }

    public List<Integer> getList() {
        return Collections.unmodifiableList(numbers);
    }
}
