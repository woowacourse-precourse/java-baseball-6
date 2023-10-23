package baseball;

public class Score {
    private static final int STRIKE_WHEN_USER_WIN = 3;
    private final int strike;
    private final int ball;

    public Score() {
        strike = 0;
        ball = 0;
    }

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String getHint() {
        String hint = ball + "볼 " + strike + "스트라이크";

        if (strike == STRIKE_WHEN_USER_WIN) {
            hint = Message.USER_WIN.text();
        } else if (ball == 0 && strike == 0) {
            hint = Message.NOTHING.text();
        } else if (ball == 0) {
            hint = strike + "스트라이크";
        } else if (strike == 0) {
            hint = ball + "볼";
        }
        return hint;
    }

    public boolean isUserLose() {
        return strike != STRIKE_WHEN_USER_WIN;
    }
}
