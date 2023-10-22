package baseball.model.service;

public interface RestartNumber {
    void isNonNumber(String inputNumber);

    void isLengthCorrect(String inputNumber);

    void isRange(Integer convertNumber);
}
