package baseball.domain;

import java.util.Objects;

public class Position {
    private final int positionNum;

    public Position(int positionNum) {
        this.positionNum = positionNum;
    }

    public int getPositionNum() {
        return positionNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return positionNum == position.positionNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionNum);
    }
}
