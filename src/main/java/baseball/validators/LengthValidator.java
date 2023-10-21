package baseball.validators;

public class LengthValidator implements Validator {

    private static final int VALID_LENGTH = 3;

    @Override
    public void validate(String userInput) {
        if (userInput.length() != VALID_LENGTH) {
            throw new IllegalArgumentException("올바른 숫자 3가지를 입력해주세요.");
        }
    }
}
