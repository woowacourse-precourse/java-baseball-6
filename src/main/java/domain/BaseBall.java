package domain;

import java.util.Objects;

public class BaseBall {
    private static final int MINIMUN = 1;
    private static final int MAXIMIN = 9;
    public final int baseballNumber;

    public BaseBall(int baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBall baseBall = (BaseBall) o;
        return baseballNumber == baseBall.baseballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumber);
    }
}
