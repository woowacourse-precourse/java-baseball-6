package baseball;

import java.util.List;

public class BaseBallNumber {
    private List<Integer> baseballNumber;

    public BaseBallNumber(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public Integer getNumberByIndex(int index) {
        return baseballNumber.get(index);
    }

    public boolean checkStrike(Integer userNumber, int index) {
        Integer answerNumber = getNumberByIndex(index);
        return answerNumber.equals(userNumber);
    }

    public boolean checkBall(Integer userNumber, int index) {
        if (checkStrike(userNumber, index)) {
            return false;
        }
        return baseballNumber.contains(userNumber);
    }

    public Integer getStrikeCount(BaseBallNumber userNumber) {
        Integer strikeCount = 0;
        for (int i = 0; i < 3; ++i) {
            Integer number = userNumber.getNumberByIndex(i);
            if (checkStrike(number, i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public Integer getBallCount(BaseBallNumber userNumber) {
        Integer ballCount = 0;
        for (int i = 0; i < 3; ++i) {
            Integer number = userNumber.getNumberByIndex(i);
            if (checkBall(number, i)) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
