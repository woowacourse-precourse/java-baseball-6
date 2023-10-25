package baseball.util;

import baseball.number.Number;
import baseball.number.Numbers;
import baseball.result.Result;
import baseball.result.Status;

/**
 * User와 Computer의 숫자 비교를 도와주는 유틸이다.
 *
 * @author Seongha Park
 */
public class NumbersComparator {
    /**
     * 볼과 스트라이크로 각각 나누어 계산한다. 볼의 경우 서로의 Numbers에 존재하면서도 같은 인덱스에 존재하지 않는 개수를 계산한다. 스트라이크의 경우 같은 인덱스에 같은 값이 존재하는지 확인한다.
     *
     * @param target User 혹은 Computer의 Numbers를 나타낸다.
     * @param other  Computer 혹은 User의 Numbers를 나타낸다.
     * @return 비교한 결과값을 담은 Result 클래스이다.
     */
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
