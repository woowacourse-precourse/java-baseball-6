package baseball.model;

import java.util.List;

public class Computer implements Playable {
    private BaseballNumber baseballNumber;

    @Override
    public List<Integer> getBaseballNumber() {
        return baseballNumber.getBaseballNumberList();
    }

    @Override
    public void updateBaseballNumber(BaseballNumber baseballNumber) {
        this.baseballNumber = baseballNumber;
    }
}
