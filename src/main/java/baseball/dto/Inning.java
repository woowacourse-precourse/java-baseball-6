package baseball.dto;

import baseball.enums.Hint;

public record Inning(int strike, String result) {
    public static Inning ofBall(int ball) {
        return new Inning(0, ball + Hint.BALL.getValue());
    }

    public static Inning ofStrike(int strike) {
        return new Inning(strike, strike + Hint.STRIKE.getValue());
    }

    public static Inning ofBallAndStrike(int ball, int strike) {
        return new Inning(strike, ball + Hint.BALL.getValue() + " " + strike + Hint.STRIKE.getValue());
    }

    public static Inning ofNothing() {
        return new Inning(0, Hint.NOTHING.getValue());
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }
}
