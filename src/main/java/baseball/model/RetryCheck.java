package baseball.model;

import java.util.Objects;

public class RetryCheck {
    private final String num;

    public RetryCheck(String num) {
        checkRetryInput(num);
        this.num = num;
    }

    public boolean isRetry() {
        if (this.num == "1") {
            return true;
        }
        return false;
    }

    private static void checkRetryInput(String number) {
        if (!Objects.equals(number, "2") && !Objects.equals(number, "1")) {
            throw new IllegalArgumentException();
        }
    }
}
