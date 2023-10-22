package baseball.domain;

import static baseball.domain.numbers.NumbersConstant.NUMBER_COUNT;

public class Result {
    public static final String STRIKE_STRING = "스트라이크";
    public static final String BALL_STRING = "볼";
    public static final String NON_STRING = "낫싱";

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
        if (isNon()) {
            return NON_STRING;
        }

        return getBallStrikeString();
    }

    private String getBallStrikeString() {
        String resultString = "";

        if (isBallPresent()) {
            resultString += getBallString();
        }

        if (isStrikePresent()) {
            if (isBallPresent()) {
                resultString += " ";
            }
            resultString += getStrikeString();
        }

        return resultString;
    }

    private boolean isNon() {
        return !isStrikePresent() && !isBallPresent();
    }

    private String getStrikeString() {
        return strike + STRIKE_STRING;
    }

    private String getBallString() {
        return ball + BALL_STRING;
    }

    private boolean isStrikePresent() {
        return !strike.equals(0);
    }

    private boolean isBallPresent() {
        return !ball.equals(0);
    }

    public boolean isContinue() {
        return !strike.equals(NUMBER_COUNT);
    }
}
