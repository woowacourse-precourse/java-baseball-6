package baseball.domain;

import java.util.Objects;

public class Position {
    private final int position;
    private final int MIN_INDEX = 1;
    private final int MAX_INDEX = 3;

    public Position(int position) {
        if (position < MIN_INDEX || position > MAX_INDEX) {
            throw new IllegalArgumentException("유효하지 않은 자리수 값 입력");
        }
        this.position = position;
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