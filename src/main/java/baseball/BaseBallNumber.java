package baseball;

import java.util.List;
import java.util.Objects;

public class BaseBallNumber {
    private List<Integer> baseballNumber;

    public BaseBallNumber(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public Integer getStrikeCount(BaseBallNumber userNumber) {
        Integer strikeCount = 0;
        for (int i = 0; i < 3; ++i) {
            if (Objects.equals(baseballNumber.get(i), userNumber.baseballNumber.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
