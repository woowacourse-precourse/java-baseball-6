package baseball;

public class Ball {
    private final Integer number;

    public Ball(Integer number) {
        checkRange(number);
        this.number = number;
    }

    public Ball(char c) {
        this.number = Character.getNumericValue(c);
    }

    public void checkRange(Integer number) {
        if(number < 1 || number > 9) {
            throw new IllegalArgumentException("숫자는 1부터 9까지만 가능합니다.");
        }
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
