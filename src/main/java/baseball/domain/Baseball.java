package baseball.domain;

import static baseball.utils.Constants.NUMBER_SIZE;

import java.util.Objects;

public record Baseball(
        int ball,
        int strike
) {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Baseball baseball = (Baseball) o;
        return ball == baseball.ball && strike == baseball.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }
}
