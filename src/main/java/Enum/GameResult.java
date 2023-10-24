package Enum;

import java.util.Arrays;

public enum GameResult {
    NO_BALL_THREE_STRIKE("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료", 0, 3),
    NO_BALL_TWO_STRIKE("2스트라이크", 0, 2),
    TWO_BALL_ONE_STRIKE("2볼 1스트라이크", 2, 1),
    ONE_BALL_ONE_STRIKE("1볼 1스트라이크", 1, 1),
    NO_BALL_ONE_STRIKE("1스트라이크", 0, 1),
    THREE_BALL_NO_STRIKE("3볼", 3, 0),
    TWO_BALL_NO_STRIKE("2볼", 2, 0),
    ONE_BALL_NO_STRIKE("1볼", 1, 0),
    NOTHING("낫싱", 0, 0);

    private final String message;
    private final int ball;
    private final int strike;

    GameResult(String message, int ball, int strike) {
        this.message = message;
        this.ball = ball;
        this.strike = strike;
    }

    public static String getMessage(int ball, int strike) {
        return Arrays.stream(GameResult.values())
                .filter(gameResult -> gameResult.ball == ball)
                .filter(gameResult -> gameResult.strike == strike)
                .map(gameResult -> gameResult.message)
                .findAny()
                .orElse(NOTHING.message);
    }
}
