package baseball.domain.ball;

import java.util.Objects;

public class Position {
    private static final int MIN_POSITION = 1;
    private static final int MAX_POSITION = 3;

    private final int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < MIN_POSITION || position > MAX_POSITION) {
            throw new IllegalArgumentException("공의 위치는 1에서 3사이의 값이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
