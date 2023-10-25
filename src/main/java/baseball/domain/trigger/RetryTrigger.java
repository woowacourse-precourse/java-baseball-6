package baseball.domain.trigger;

public class RetryTrigger {
    private final static int RETRY = 1;
    private final static int END = 2;
    private final static String WRONG_RETRY_NUMBER = "1 또는 2만 입력 가능합니다.";

    private final int trigger;

    public RetryTrigger(int trigger) {
        validator(trigger);
        this.trigger = trigger;
    }

    public boolean retryOrNot() {
        return trigger == RETRY;
    }

    private void validator(int trigger) {
        if (trigger == RETRY || trigger == END) {
            return;
        }
        throw new IllegalArgumentException(WRONG_RETRY_NUMBER);
    }
}
