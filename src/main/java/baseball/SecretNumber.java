package baseball;

import java.util.ArrayList;
import java.util.List;

public class SecretNumber extends ImmutableList<Digit> implements List<Digit> {
    public static final int SIZE = 3;
    private static final List<SecretNumberValidator> validatorList = new ArrayList<>();

    static {
        validatorList.add(new SecretNumberSizeValidator());
        validatorList.add(new SecretNumberUniqueValidator());
    }

    public SecretNumber(List<Digit> digits) {
        super(digits);
        validate();
    }

    private void validate() {
        for (SecretNumberValidator validator : validatorList) {
            validator.validate(this);
        }
    }
}
