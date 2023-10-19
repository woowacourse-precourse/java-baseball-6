package baseball.domain;

import java.util.Objects;

public class BallNum {
    private final int number;

    public BallNum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNum ballNum = (BallNum) o;
        return number == ballNum.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
