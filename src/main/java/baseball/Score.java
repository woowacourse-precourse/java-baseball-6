package baseball;

public class Score {
    private static final String USER_WIN = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL_EXIST = "볼";
    private static final String STRIKE_EXIST = "스트라이크";
    private static final String NOTHING = "낫싱";
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
        String hint = ball + BALL_EXIST + " " + strike + STRIKE_EXIST;

        hint = checkCondition(hint);
        return hint;
    }

    private String checkCondition(String hint) {
        if (strike == STRIKE_WHEN_USER_WIN) {
            hint = USER_WIN;
        } else if (ball == 0 && strike == 0) {
            hint = NOTHING;
        } else if (ball == 0) {
            hint = strike + STRIKE_EXIST;
        } else if (strike == 0) {
            hint = ball + BALL_EXIST;
        }
        return hint;
    }

    public boolean isUserLose() {
        return strike != STRIKE_WHEN_USER_WIN;
    }
}
