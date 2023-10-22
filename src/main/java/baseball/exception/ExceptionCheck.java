package baseball.exception;

import java.util.Objects;

public class ExceptionCheck {

    public void playerInputCheck(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
