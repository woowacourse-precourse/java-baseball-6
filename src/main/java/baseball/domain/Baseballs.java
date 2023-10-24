package baseball.domain;

import java.util.List;

import static baseball.validator.BaseballsValidator.validate;


public class Baseballs {

    public static final int MIN_BALL = 1;
    public static final int MAX_BALL = 9;
    public static final int BALL_SIZE = 3;

    private final List<Integer> baseballs;

    public Baseballs(List<Integer> baseballs) {
        validate(baseballs);
        this.baseballs = List.copyOf(baseballs);
    }

    public Integer getBall(int index) {
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

    private boolean isStrike(int index, Baseballs playerBaseballs) {
        Integer computerBaseball = this.getBall(index);
        Integer playerBaseball = playerBaseballs.getBall(index);
        return computerBaseball.equals(playerBaseball);
    }

    private boolean containsOtherBall(Integer otherBaseball) {
        for (Integer baseball : baseballs) {
            if (baseball.equals(otherBaseball)) {
                return true;
            }
        }
        return false;
    }
}