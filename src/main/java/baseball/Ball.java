package baseball;

public class Ball {
    private final Integer number;

    public Ball(int number) {
        rangeCheck(number);
        this.number = number;
    }

    public Ball(char ch) {
        this(Integer.parseInt(String.valueOf(ch)));
    }

    // 수의 범위 체크 (1~9 자연수)
    private void rangeCheck(int number) {
        if(number < 1 || number > 9) {
            throw new IllegalArgumentException("1~9 사이의 자연수만 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        Ball ball = (Ball) obj;
        return this.number.equals(ball.number);
    }

    @Override
    public String toString() {
        return this.number.toString();
    }

    @Override
    public int hashCode() {
        if(number == null) {
            return 0;
        }
        return number.hashCode();
    }
}
