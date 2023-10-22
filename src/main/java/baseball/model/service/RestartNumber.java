package baseball.model.service;

public interface RestartNumber {
    void isNonNumber(String inputNumber);

    void isLengthCorrect(Integer convertNumber);

    void isRange(Integer convertNumber);
}
