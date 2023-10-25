package baseball;

import java.util.Objects;

public class Pick {

    private final int number;

    public Pick(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pick pick = (Pick) o;
        return number == pick.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
