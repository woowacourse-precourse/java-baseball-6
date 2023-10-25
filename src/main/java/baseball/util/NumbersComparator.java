package baseball.util;

import baseball.number.Number;
import baseball.number.Numbers;
import baseball.result.Result;
import baseball.result.Status;

public class NumbersComparator {
    public Result compareWith(Numbers target, Numbers other) {
        Status ball = calculateBall(target, other);
        Status strike = calculateStrike(target, other);

        return new Result(ball, strike);
    }

    private Status calculateBall(Numbers target, Numbers other) {
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            Number thisDigit = target.getNumber(i);
            ballCount += isBall(thisDigit, other, i);
        }

        return new Status(ballCount);
    }

    private int isBall(Number targetNumber, Numbers other, int index) {
        int includeIndex = other.includeNumber(targetNumber);
        if (includeIndex >= 0 && includeIndex != index) {
            return 1;
        }
        return 0;
    }

    private Status calculateStrike(Numbers target, Numbers other) {
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            int targetDigit = target.getNumber(i).number();
            int otherDigit = other.getNumber(i).number();
            strikeCount += isStrike(targetDigit, otherDigit);
        }

        return new Status(strikeCount);
    }

    private int isStrike(Integer thisDigit, Integer otherDigit) {
        if (thisDigit == otherDigit) {
            return 1;
        }
        return 0;
    }
}
