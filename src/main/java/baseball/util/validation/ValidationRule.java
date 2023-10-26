package baseball.util.validation;

public sealed interface ValidationRule permits FormatValidationRule, NumericValidationRule, LengthValidationRule {
    void validate(String playerNumber);
}
