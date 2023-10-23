package baseball.domain.baseball;

import baseball.domain.util.Output;

import static baseball.domain.baseball.BaseballConst.FINISH_STRIKE_COUNT;

public class BaseballResult {
    private int ball;
    private int strike;

    public BaseballResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void addBall() {
        ball++;
    }

    public void addStrike() {
        strike++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getBall() == 0 && getStrike() == 0) {
            sb.append(BaseballConst.NOTHING_MESSAGE);
        } else {
            if (getBall() != 0) {
                sb.append(getBall()).append(BaseballConst.BALL_MESSAGE);
            }
            if (getStrike() != 0) {
                sb.append(getStrike()).append(BaseballConst.STRIKE_MESSAGE);
            }
        }

        return sb.toString();
    }

    public void printResult() {
        System.out.println(this);

        if (getStrike() == FINISH_STRIKE_COUNT) {
            Output.printMessageWithLine(BaseballConst.STRIKE_GAME_FINISH_MESSAGE);
        }
    }

    public boolean isEnd() {
        return getStrike() == FINISH_STRIKE_COUNT;
    }

    public void refresh() {
        ball = 0;
        strike = 0;
    }
}