package baseball.exception;

import java.util.Objects;

public class ExceptionCheck {

    public void playerInputCheck(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void restartInputCheck(String inputNumber) {
        if (!(Objects.equals(inputNumber, "1")) && !(Objects.equals(inputNumber, "2"))) {
            throw new IllegalArgumentException();
        }
    }
}
