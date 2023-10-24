package baseball.util;

public class Validator {

    public static String getValidatedPlayerNumber(String playerNumber) {
        ValidationRule validationRules = ValidationRules.createValidationRules();

        validationRules.FormatValidationRule(playerNumber);
        validationRules.NumericValidationRule(playerNumber);
        validationRules.LengthValidationRule(playerNumber);
        return playerNumber;
    }
}
