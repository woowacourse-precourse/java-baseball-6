package baseball;

public class Validation {
    public void validationNumber(String answer) {
        if (answer.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
