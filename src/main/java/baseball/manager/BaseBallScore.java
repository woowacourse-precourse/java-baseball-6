package baseball.manager;

public class BaseBallScore {
    private static final String BALL_FORMAT = "%s볼";
    private static final String STRIKE_FORMAT = "%s스트라이크";
    private static final String NOTHING_FORMAT = "낫싱";
    private final int maxGameCount;
    private int strike;
    private int ball;
    private int nothing;

    BaseBallScore(int maxGameCount) {
        strike = 0;
        ball = 0;
        nothing = 0;
        this.maxGameCount = maxGameCount;
    }

    void increaseStrike() {
        strike++;
        validateScore();
    }

    void increaseBall() {
        ball++;
        validateScore();
    }

    void increaseNothing() {
        nothing++;
        validateScore();
    }

    private void validateScore() {
        if (this.strike + this.ball + this.nothing > maxGameCount) {
            throw new IllegalArgumentException();
        }
    }

    Boolean verifyingWinGame() {
        return (this.nothing == 0) && (this.ball == 0) && (this.strike == maxGameCount);
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        if (this.ball != 0) {
            outputString.append(String.format(BALL_FORMAT, this.ball)).append(" ");
        }
        if (this.strike != 0) {
            outputString.append(String.format(STRIKE_FORMAT, this.strike));
        }
        if (this.nothing == 3) {
            outputString.append(NOTHING_FORMAT);
        }
        return outputString.toString();
    }
}
