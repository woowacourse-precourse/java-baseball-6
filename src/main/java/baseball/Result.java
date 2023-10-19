package baseball;

import static baseball.Const.FINISH_STRIKE_COUNT;

public class Result {
    private int ball;
    private int strike;

    public Result(int ball, int strike) {
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
            sb.append(Const.NOTHING_MESSAGE);
        } else {
            if (getBall() != 0) {
                sb.append(getBall()).append(Const.BALL_MESSAGE);
            }
            if (getStrike() != 0) {
                sb.append(getStrike()).append(Const.STRIKE_MESSAGE);
            }
        }

        return sb.toString();
    }

    public void printResult() {
        System.out.println(this);

        if (getStrike() == FINISH_STRIKE_COUNT) {
            Output.printMessageWithLine(Const.STRIKE_GAME_FINISH_MESSAGE);
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