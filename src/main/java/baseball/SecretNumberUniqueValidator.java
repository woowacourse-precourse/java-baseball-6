package baseball;

import java.util.HashSet;
import java.util.Set;

public class SecretNumberUniqueValidator implements SecretNumberValidator {
    public void validate(SecretNumber secretNumber) {
        Set<Digit> usedDigits = new HashSet<>(secretNumber);
        if (usedDigits.size() != SecretNumber.SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
