package baseball.gameLogic;

import baseball.models.Score;

import java.util.List;

import static baseball.utils.Constants.*;

/*
 주어진 숫자가 볼인지 스트라이크인지 판별하고 점수를 리턴하는 클래스
 */

public class NumberChecker {
    private List<Integer> user;
    private List<Integer> computer;

    public Score checkNumber(List<Integer> user, List<Integer> computer) {
        this.user = user;
        this.computer = computer;

        return countBallAndStrike();
    }

    public Score countBallAndStrike() {
        int ballCount = 0;
        int strikeCount = 0;

        for (int index = 0; index < ANSWER_LENGTH; index++) {
            if (isStrike(index)) {
                strikeCount++;
            } else if (isBall(index)) {
                ballCount++;
            }
        }

        return new Score(ballCount, strikeCount);
    }

    public boolean isStrike(int index) {
        int userDigit = user.get(index);
        int computerDigit = computer.get(index);

        return userDigit == computerDigit;
    }

    public boolean isBall(int index) {
        int userDigit = user.get(index);

        return computer.contains(userDigit);
    }

}
