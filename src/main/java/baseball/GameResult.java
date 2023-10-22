package baseball;

import java.util.Arrays;

public enum GameResult {
    THREE_STRIKES(0, 3),
    TWO_STRIKES(0, 2),
    ONE_STRIKE(0, 1),
    THREE_BALLS(3, 0),
    TWO_BALLS(2, 0),
    ONE_BALL(1, 0),
    TWO_BALLS_ONE_STRIKE(2, 1),
    ONE_BALL_ONE_STRIKE(1, 1),
    NOTHING(0, 0),
    MISS(-1, -1),
    ;

    private final int ball;
    private final int strike;

    GameResult(final int ball, final int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static GameResult valueOf(final int ball, final int strike) {
        return Arrays.stream(values())
                .filter(gameResult -> gameResult.ball == ball && gameResult.strike == strike)
                .findFirst()
                .orElse(MISS);
    }

    public boolean isThreeStrikes() {
        return this.equals(THREE_STRIKES);
    }
}
