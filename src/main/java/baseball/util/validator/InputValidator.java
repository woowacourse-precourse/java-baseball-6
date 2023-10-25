package baseball.util.validator;

public interface InputValidator {
    boolean validate(
            String input, int numberDigits, int startInclusive, int endInclusive, boolean validateUniqueValue
    );
    boolean validate(String input, int numberDigits, int startInclusive, int endInclusive);
}
