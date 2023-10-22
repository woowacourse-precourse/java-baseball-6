package baseball.model;

import java.util.Objects;

public class RetryCheck {
    private final String num;

    public RetryCheck(String num) {
        checkRetryInput(num);
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    private static void checkRetryInput(String number) {
        if (!Objects.equals(number, "2") && !Objects.equals(number, "1")) {
            throw new IllegalArgumentException();
        }
    }
}
