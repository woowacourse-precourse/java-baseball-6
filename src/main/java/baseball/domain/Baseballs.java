package baseball.domain;

import java.util.List;

import static baseball.domain.Baseball.*;
import static baseball.validator.BaseballsValidator.validate;

public class Baseballs {

    private final List<Baseball> baseballs;

    public Baseballs(List<Baseball> baseballs) {
        validate(baseballs);
        this.baseballs = List.copyOf(baseballs);
    }

    public Baseball getBall(int index) {
        return baseballs.get(index);
    }

    public int countBalls(Baseballs otherBaseballs) {
        int ballCount = 0;
        for (int index = 0; index < BALL_SIZE; index++) {
            if (isBall(index, otherBaseballs)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private boolean isBall(int index, Baseballs playerBaseballs) {
        boolean isNotStrike = !isStrike(index, playerBaseballs);
        boolean isContainsOtherBall = this.containsOtherBall(playerBaseballs.getBall(index));
        return isNotStrike && isContainsOtherBall;
    }

    public int countStrikes(Baseballs otherBaseballs) {
        int strikeCount = 0;
        for (int index = 0; index < BALL_SIZE; index++) {
            if (isStrike(index, otherBaseballs)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private boolean containsOtherBall(Baseball otherBaseball) {
        for (Baseball baseball : baseballs) {
            if (baseball.isSameNumber(otherBaseball)) {
                return true;
            }
        }
        return false;
    }

    private boolean isStrike(int index, Baseballs playerBaseballs) {
        Baseball computerBaseball = this.getBall(index);
        Baseball playerBaseball = playerBaseballs.getBall(index);
        return computerBaseball.number().equals(playerBaseball.number());
    }
}