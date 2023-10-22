package baseball.dto;

import baseball.enums.Hint;

public record Inning(String result) {
    public static Inning ofBall(int ball) {
        return new Inning(ball + Hint.BALL.getValue());
    }

    public static Inning ofStrike(int strike) {
        return new Inning(strike + Hint.STRIKE.getValue());
    }

    public static Inning ofBallAndStrike(int ball, int strike) {
        return new Inning(ball + Hint.BALL.getValue() + " " + strike + Hint.STRIKE.getValue());
    }

    public static Inning ofNothing() {
        return new Inning(Hint.NOTHING.getValue());
    }
}
