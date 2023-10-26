package baseball.util.validation;

import java.util.Arrays;
import java.util.List;

public class Validator {

    private final List<ValidationRule> validationRules;

    public Validator() {
        this.validationRules = Arrays.asList(FormatValidationRule.create(), NumericValidationRule.create(),
                LengthValidationRule.create());
    }

    public static String getValidatedPlayerNumber(String playerNumber) {
        Validator validator = new Validator();
        validator.validationRules.forEach(rule -> rule.validate(playerNumber));
        return playerNumber;
    }
}