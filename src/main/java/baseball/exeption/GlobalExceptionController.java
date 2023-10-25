package baseball.exeption;

public interface GlobalExceptionController {
    void notIntegerException(String Number);

    void duplicationException(String Number);

    void notThreeDigitException(String Number);

    void zeroValueException(String Number);
}
