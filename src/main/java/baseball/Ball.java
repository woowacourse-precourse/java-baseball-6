package baseball;

public class Ball {
    private final int number;

    public Ball(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Ball ball = (Ball) object;

        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
