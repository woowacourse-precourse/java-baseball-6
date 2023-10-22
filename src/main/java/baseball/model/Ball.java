package baseball.model;

import java.util.Objects;

public class Ball {
    int index;
    int number;

    public Ball(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public boolean isBall(Ball ball) {
        return this.index != ball.getIndex() && this.number == ball.getNumber();
    }

    public int getIndex() {
        return index;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball ball)) {
            return false;
        }
        return index == ball.index && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, number);
    }

}
