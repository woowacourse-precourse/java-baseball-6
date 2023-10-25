package baseball.policy;

public interface ValidationPolicy {
    void isCorrectLength(String input);
    void isNumericString(String input);
    void hasNoDuplicateNumber(String input);
    void hasNoZero(String input);
    void isNullOrEmpty(String input);
}
