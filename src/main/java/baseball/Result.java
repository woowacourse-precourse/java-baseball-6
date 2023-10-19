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
            sb.append("낫싱");
        } else {
            if (getBall() != 0) {
                sb.append(getBall()).append("볼 ");
            }
            if (getStrike() != 0) {
                sb.append(getStrike()).append("스트라이크");
            }
        }

        return sb.toString();
    }

    public void printResult() {
        System.out.println(this);

        if (getStrike() == FINISH_STRIKE_COUNT) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public boolean isEnd() {
        return getStrike() == FINISH_STRIKE_COUNT;
    }
}