package baseball.domain.entity;

import baseball.constants.PrintConst;

public record Hint(int strike, int ball) {
    private boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    private String getBallMessage() {
        return ball > 0 ? String.format(PrintConst.BALL.getMessage(), ball) : PrintConst.EMPTY_STRING.getMessage();
    }

    private String getStrikeMessage() {
        return strike > 0 ? String.format(PrintConst.STRIKE.getMessage(), strike) : PrintConst.EMPTY_STRING.getMessage();
    }

    @Override
    public String toString() {
        return isNothing() ? PrintConst.NOTHING.getMessage() : getBallMessage() + getStrikeMessage();
    }
}
