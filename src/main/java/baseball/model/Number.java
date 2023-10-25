package baseball.model;

import java.util.ArrayList;
import java.util.List;

abstract class Number {
    protected static final int length = 3;
    private final List<Integer> digits;

    public Number(List<Integer> digits) {
        assert digits.size() == length;

        this.digits = new ArrayList<>(digits);
    }

    public int getDigit(int index) {
        assert index >= 0 && index < length;

        return this.digits.get(index);
    }

    public List<Integer> getDigits() {
        return this.digits;
    }
}
