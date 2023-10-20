package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

class Digit {

    private final int digit;

    Digit() {
        this.digit = Randoms.pickNumberInRange(1, 9);
    }

    Digit(char target) {
        this.digit = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit target = (Digit) o;
        return digit == target.digit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(digit);
    }
}