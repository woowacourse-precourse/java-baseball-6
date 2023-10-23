package baseball.model.service;

public interface RestartOptionValidator {
    void isNonNumber(String inputNumber);

    void isLengthCorrect(String inputNumber);

    void isRange(Integer convertNumber);
}
