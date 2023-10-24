package baseball.domain;

public class Hint {
    private static final String STRIKE_TEXT = "스트라이크";
    private static final String BALL_TEXT = "볼";
    private static final String NOTHING_TEXT = "낫싱";
    private static final int WINNING_STRIKE_COUNT = 3;
    private final int strikes;
    private final int balls;

    public Hint(final int strikes, final int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isGameFinished() {
        return strikes == WINNING_STRIKE_COUNT;
    }


    public String formatResult() {
        return getResultText();
    }

    private String getResultText() {
        if (isNothing()) {
            return NOTHING_TEXT;
        }
        return getBallText() + getStrikeText();
    }

    private boolean isNothing() {
        return strikes == 0 && balls == 0;
    }

    private String getStrikeText() {
        return strikes > 0 ? strikes + STRIKE_TEXT : "";
    }

    private String getBallText() {
        return balls > 0 ? balls + BALL_TEXT + " " : "";
    }
}
