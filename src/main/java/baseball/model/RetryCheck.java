package baseball.model;

import static baseball.util.ValidationChecking.checkRetryInput;

public class RetryCheck {
    private final String num;

    public RetryCheck(String num) {
        checkRetryInput(num);
        this.num = num;
    }

    public String getNum() {
        return num;
    }
}
