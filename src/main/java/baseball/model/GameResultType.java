package baseball.model;

import java.util.function.IntPredicate;

public enum GameResultType {
    NOTHING(strike -> strike == 0, ball -> ball == 0, "낫싱", false),
    ANSWER(strike -> strike == 3, ball -> ball == 0, "3스트라이크", true),
    ONLY_STRIKE(strike -> strike >= 1, ball -> ball == 0, "%d스트라이크", false),
    STRIKE_AND_BALL(strike -> strike >= 1, ball -> ball >= 1, "%d볼 %d스트라이크", false),
    ONLY_BALL(strike -> strike == 0, ball -> ball >= 1, "%d볼", false);

    private final IntPredicate strike;
    private final IntPredicate ball;
    private final String gameResultMessage;
    private final boolean isCorrectAnswer;

    GameResultType(IntPredicate strike, IntPredicate ball,
                   String gameResultMessage, boolean isCorrectAnswer) {
        this.strike = strike;
        this.ball = ball;
        this.gameResultMessage = gameResultMessage;
        this.isCorrectAnswer = isCorrectAnswer;
    }

    public static GameResultType findType(int strike, int ball) {
        for (GameResultType gameResultType : values()) {
            if (gameResultType.strike.test(strike) && gameResultType.ball.test(ball)) {
                return gameResultType;
            }
        }
        throw new IllegalArgumentException("올바른 결과를 찾지 못했습니다.");
    }

    public String getGameResultMessage() {
        return gameResultMessage;
    }

    public boolean isCorrectAnswer() {
        return isCorrectAnswer;
    }
}
