package baseball;

import java.util.Arrays;

public enum GameResult {
    THREE_STRIKES(0, 3, "3스트라이크"),
    TWO_STRIKES(0, 2, "2스트라이크"),
    ONE_STRIKE(0, 1, "1스트라이크"),
    THREE_BALLS(3, 0, "3볼"),
    TWO_BALLS(2, 0, "2볼"),
    ONE_BALL(1, 0, "1볼"),
    TWO_BALLS_ONE_STRIKE(2, 1, "2볼 1스트라이크"),
    ONE_BALL_ONE_STRIKE(1, 1, "1볼 1스트라이크"),
    NOTHING(0, 0, "낫싱"),
    MISS(-1, -1, "미스"),
    ;

    private final int ball;
    private final int strike;
    private final String message;

    GameResult(final int ball, final int strike, final String message) {
        this.ball = ball;
        this.strike = strike;
        this.message = message;
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

    @Override
    public String toString() {
        return message;
    }
}
