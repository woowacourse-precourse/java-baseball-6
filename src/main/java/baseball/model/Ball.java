package baseball.model;

public class Ball {
    public static final int START_RANGE = 1;
    public static final int END_RANGE = 9;
    private int num;

    public Ball(int num) {
        if (!isInRange(num)) {
            throw new IllegalArgumentException("1-9사이의 숫자를 입력해야 합니다.");
        }
        this.num = num;
    }

    private static boolean isInRange(int num) {
        return START_RANGE <= num && num <= END_RANGE;
    }

    public int getNum() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball ball)) return false;

        return getNum() == ball.getNum();
    }

    @Override
    public int hashCode() {
        return getNum();
    }
}
