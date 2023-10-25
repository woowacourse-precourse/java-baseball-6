package baseball;

import java.util.List;

public class SecretNumber extends ImmutableList<Digit> implements List<Digit> {
    public static final int SIZE = 3;

    public SecretNumber(List<Digit> digits) {
        super(digits);
    }
}
