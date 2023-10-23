package baseball.util;

public interface ValidationRule {
    void FormatValidationRule(String playerNumber);

    void NumericValidationRule(String playerNumber);

    void LengthValidationRule(String playerNumber);
}
