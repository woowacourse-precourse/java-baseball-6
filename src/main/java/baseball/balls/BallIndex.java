package baseball.balls;

import java.util.Objects;

public class BallIndex {

    private final int index;

    public BallIndex(int index) {
        validateIndexRange(index);
        this.index = index;
    }

    private void validateIndexRange(int value) {
        if (value < 0 || value >= Balls.BALL_COUNT) {
            throw new IllegalArgumentException("공의 위치값이 유효하지 않은 값입니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        BallIndex otherBallIndex = (BallIndex) obj;
        return index == otherBallIndex.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

}
