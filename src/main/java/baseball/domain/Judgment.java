package baseball.domain;

import java.util.Objects;

public class Judgment {
    private static final int NUMBER_SIZE = 3;
    private int ball;
    private int strike;

    public void judge(Computer computer, Player player) {
        strike = computer.countSameIndexNumber(player);
        ball = computer.countContainNumber(player) - strike;
    }

    public Boolean isBallAndStrike() {
        return ball > 0 && strike > 0;
    }

    public Boolean isBall() {
        return ball > 0 && strike == 0;
    }

    public Boolean isAllStrike() {
        return ball == 0 && strike == NUMBER_SIZE;
    }

    public Boolean isStrike() {
        return ball == 0 && strike > 0;
    }

    public Boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Judgment judgment = (Judgment) o;
        return ball == judgment.ball && strike == judgment.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }
}
