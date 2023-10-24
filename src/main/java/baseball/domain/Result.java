package baseball.domain;

import static baseball.domain.numberBalls.NumberBallsConstant.NUMBER_COUNT;

public class Result {
    private static final String STRIKE_STRING = "스트라이크";
    private static final String BALL_STRING = "볼";
    private static final String NON_STRING = "낫싱";
    private static final String BLANK = " ";
    private static final String EMPTY = "";
    private static final Integer ZERO = 0;


    private Integer ball;
    private Integer strike;


    private Result() {
    }

    public static Result create(Integer ball, Integer strike) {
        Result result = new Result();
        result.setBall(ball);
        result.setStrike(strike);

        return result;
    }

    private void setBall(Integer ball) {
        this.ball = ball;
    }

    private void setStrike(Integer strike) {
        this.strike = strike;
    }

    /*
     * 출력 예시 :
     *  3스트라이크
     *  1볼 2스트라이크
     *  1볼
     *  낫싱
     */
    @Override
    public String toString() {
        String result = getBallString() + BLANK + getStrikeString();
        result = result.trim();

        if (result.isEmpty()) {
            return NON_STRING;
        }

        return result;
    }

    private String getStrikeString() {
        if (strike.equals(ZERO)) {
            return EMPTY;
        }

        return strike + STRIKE_STRING;
    }

    private String getBallString() {
        if (ball.equals(ZERO)) {
            return EMPTY;
        }

        return ball + BALL_STRING;
    }

    public boolean isContinue() {
        return !strike.equals(NUMBER_COUNT);
    }
}
