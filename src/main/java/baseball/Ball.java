package baseball;

public class Ball {
    private final int ball;

    public Ball(int ball) {
        if (ball < GameConfig.MIN_NUMBER.getValue() || ball > GameConfig.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(GameMessage.WRONG_INPUT.getMessage());
        }

        this.ball = ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this.getClass() == o.getClass()) {
            Ball b = (Ball) o;

            return ball == b.ball;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return ball;
    }
}
