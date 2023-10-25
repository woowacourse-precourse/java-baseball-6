package baseball.model;

import java.util.List;

public class Player implements Playable {
    private BaseballNumber baseballNumber;

    @Override
    public void updateBaseballNumber(BaseballNumber baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    @Override
    public List<Integer> getBaseballNumber() {
        return baseballNumber.getBaseballNumberList();
    }
}
