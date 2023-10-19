package baseball;

public class Ball {
    private final Integer number;

    public Ball(Integer number) {
        GlobalExcept.checkRange(number);
        this.number = number;
    }

    public Ball(char c) {
        this.number = Character.getNumericValue(c);
    }

    @Override
    public boolean equals(Object obj) {
        Ball ball;
        if (obj instanceof Ball) {
            ball = (Ball)obj;

        } else {
            throw new IllegalArgumentException("같은 객체가 아닙니다.");
        }
        return this.number.equals(ball.number);
    }



    @Override
    public int hashCode() {
        if (number == null) {
            return 0;
        }
        return number.hashCode();
    }
}
