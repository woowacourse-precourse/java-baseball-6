package baseball.Model;


import java.util.Objects;

public class Number {
    private static final int NUM_MIN_VALUE = 1;
    private static final int NUM_MAX_VALUE = 9;

    private static final int POSITION_MIN_VALUE = 0;
    private static final int POSITION_MAX_VALUE = 2;

    private final int num;
    private final int position;

    public Number(int num, int position) {
        validateNumRange(num);
        validatePositionRange(position);
        this.num = num;
        this.position = position;
    }

    protected boolean checkStrike(Number playerNum) {
        return this.num == playerNum.num && this.position == playerNum.position;
    }

    protected boolean checkBall(Number PlayerNum) {
        return this.num == PlayerNum.num && this.position != PlayerNum.position;
    }

    private void validateNumRange(int number) {
        if (number < NUM_MIN_VALUE || number > NUM_MAX_VALUE) {
            throw new IllegalArgumentException("1~9사이의 숫자만 가능합니다.");
        }
    }

    private void validatePositionRange(int position) {
        if (position < POSITION_MIN_VALUE || position > POSITION_MAX_VALUE) {
            throw new IllegalArgumentException("숫자의 위치가 범위를 벗어났습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return this.num == number.num && position == number.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, position);
    }
}

