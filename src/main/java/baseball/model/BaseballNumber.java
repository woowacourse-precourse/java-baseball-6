package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    private final List<BallNumber> baseballNumberList;

    public BaseballNumber(List<BallNumber> baseballNumberSet) {
        this.baseballNumberList = new ArrayList<>(baseballNumberSet);
    }
}
