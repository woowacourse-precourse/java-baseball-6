package baseball;

public class SecretNumberSizeValidator implements SecretNumberValidator {
    public void validate(SecretNumber secretNumber) {
        if (secretNumber.size() != SecretNumber.SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
