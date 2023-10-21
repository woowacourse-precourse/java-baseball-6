package baseball.model;

import baseball.view.InputView;

public class Retry {
    private String retryNumber;
    private static final String ERROR_RETRY_NUMBER = "잘못된 값을 입력하였습니다.";
    private static final String RETRY_NUMBER = "1";
    private static final String END_NUMBER = "2";

    public String getRetryNumber() {
        return retryNumber;
    }

    public Retry(String retryNumber) {
        isRetryNumber(retryNumber);
        this.retryNumber = retryNumber;
    }

    public static void isRetryNumber(String number) {
        if(!number.equals(RETRY_NUMBER)&&!number.equals(END_NUMBER)) {
            throw new IllegalStateException(ERROR_RETRY_NUMBER);
        }
    }
}
