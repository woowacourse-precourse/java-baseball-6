package baseball.policy;

public interface ValidationPolicy {
    void isCorrectLength(String input, int length);
    void isNumericString(String input);
    void hasNoDuplicateNumber(String input);
    void hasNoZero(String input);
    void isNullOrEmpty(String input);
}
