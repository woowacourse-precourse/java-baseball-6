package baseball;


import java.util.Objects;

import static baseball.Validator.isNumeric;

public class Ball {

    private final Integer number;

    public Ball(String input) {
        validateBall(input);

        this.number = Integer.parseInt(input);
    }

    public Ball(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return Objects.equals(number, ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public static boolean validateBall(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
