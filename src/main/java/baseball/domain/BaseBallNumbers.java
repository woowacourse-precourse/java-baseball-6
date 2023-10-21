package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseBallNumbers {

    private final List<Integer> baseballNumbers;

    private BaseBallNumbers(List<Integer> numbers) {
        this.baseballNumbers = numbers;
    }

    public static BaseBallNumbers emptyNumbers() {
        return new BaseBallNumbers(new ArrayList<>());
    }

}
