package baseball.domain;

import baseball.exception.RetryInputException;

public class RetryChecker {

    private final String retrySelection;

    public RetryChecker(String retrySelection) {
        checkFormat(retrySelection);
        this.retrySelection = retrySelection;
    }

    private void checkFormat(String retrySelection) {
        if (!retrySelection.equals("1") && !retrySelection.equals("2")) {
            throw new RetryInputException();
        }
    }

    public boolean isRetry() {
        return retrySelection.equals("1");
    }


}
