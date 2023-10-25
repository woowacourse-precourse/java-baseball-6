package baseball;

import java.util.AbstractList;
import java.util.List;

public class SecretNumber extends AbstractList<Digit> implements List<Digit> {
    public static final int SIZE = 3;
    private final List<Digit> digits;

    public SecretNumber(List<Digit> digits) {
        this.digits = digits;
    }

    @Override
    public Digit get(int index) {
        return digits.get(index);
    }

    @Override
    public int size() {
        return digits.size();
    }
}
