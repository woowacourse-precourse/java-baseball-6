package baseball.domain;

import java.util.List;

public class Player {
    private List<Integer> baseballNumbers;

    public void setBaseballNumbers(List<Integer> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers;
    }
}
