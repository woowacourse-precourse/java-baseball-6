package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

final class Digit {

    private int digit;

    private Digit() {
    }

    static Digit generateRandomDigit() {
        Digit randomDigit = new Digit();
        randomDigit.digit = Randoms.pickNumberInRange(1, 9);
        return randomDigit;
    }

    static Digit generateFixedDigit(final int target) {
        Digit fixedDigit = new Digit();
        fixedDigit.digit = target;
        if (fixedDigit.digit < 1 || fixedDigit.digit > 9) throw new IllegalArgumentException();
        return fixedDigit;
    }

    @Override
    public boolean equals(final Object o) {
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