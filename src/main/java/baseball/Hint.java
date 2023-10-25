package baseball;

import java.util.StringJoiner;

public class Hint {

    private final int strike;
    private final int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        StringJoiner joiner = new StringJoiner(" ");
        addStrikeToJoiner(joiner);
        addBallToJoiner(joiner);
        return joiner.toString();
    }

    private void addStrikeToJoiner(StringJoiner joiner) {
        if (ball > 0) {
            joiner.add(ball + "볼");
        }
    }

    private void addBallToJoiner(StringJoiner joiner) {
        if (strike > 0) {
            joiner.add(strike + "스트라이크");
        }
    }

    public boolean isAnswer() {
        return strike == 3 && ball == 0;
    }

}