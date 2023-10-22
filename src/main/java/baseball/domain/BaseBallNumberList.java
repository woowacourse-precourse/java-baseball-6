package baseball.domain;

import java.util.List;

public class BaseBallNumberList {

    private final List<Integer> numbers;

    public BaseBallNumberList(List<Integer> numbers) {
        this.numbers = numbers;
        validateSize();
    }

    private void validateSize() {
        if (this.numbers.size() != 3) {
            throw new IllegalArgumentException("숫자를 3개를 입력해주세요");
        }
    }
}
