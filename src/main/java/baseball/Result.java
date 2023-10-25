package baseball;

/**
 * 결과에 필요한 strrike와 ball 값을 저장
 */
public class Result {
    public static final String STRIKE_WORD = "스트라이크";
    public static final String BALL_WORD = "볼";
    public static final String NOT_FOUND_WORD = "낫싱";

    private int strike;
    private int ball;

    public Result() {
        this.strike = 0;
        this.ball = 0;
    }

    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (strike + ball == 0) {
            return NOT_FOUND_WORD;
        } else {
            if (ball != 0) {
                result.append(ball + BALL_WORD);
            }
            if (strike != 0) {
                if (!result.isEmpty()) {
                    result.append(" ");
                }
                result.append(strike + STRIKE_WORD);
            }
        }

        return result.toString();
    }
}
