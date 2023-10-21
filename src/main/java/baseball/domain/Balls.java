package baseball.domain;

import java.util.Objects;

public class Balls {

    private int number;
    private int location;

    public Balls(int number, int location) {
        this.number = number;
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Balls balls = (Balls) o;
        return number == balls.number && location == balls.location;
    }

    @Override
    public int hashCode(){
        return Objects.hash(number, location);
    }
}
