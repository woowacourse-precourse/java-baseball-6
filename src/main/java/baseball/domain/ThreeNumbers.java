package baseball.domain;

import java.util.List;

public class ThreeNumbers {
    private final List<Integer> threeNumbers;

    public ThreeNumbers(List<Integer> threeNumbers) {
        this.threeNumbers = threeNumbers;
    }

    public List<Integer> getThreeNumbers() {
        return threeNumbers;
    }
}

