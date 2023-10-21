package baseball;

import java.util.List;

public class BaseBallNumber {
    private List<Integer> baseballNumber;

    public BaseBallNumber(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public boolean checkStrike(Integer userNumber, int index) {
        Integer answerNumber = baseballNumber.get(index);
        return answerNumber.equals(userNumber);
    }

    public Integer getStrikeCount(BaseBallNumber userNumber) {
        Integer strikeCount = 0;
        for (int i = 0; i < 3; ++i) {
            Integer number = userNumber.baseballNumber.get(i);
            if (checkStrike(number, i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public Integer getBallCount(BaseBallNumber userNumber) {
        Integer ballCount = 0;
        for (int i = 0; i < 3; ++i) {
            Integer number = userNumber.baseballNumber.get(i);
            if (baseballNumber.contains(number) && !checkStrike(number, i)) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
