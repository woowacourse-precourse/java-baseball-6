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
            hint = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else if (ball == 0 && strike == 0) {
            hint = "낫싱";
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
