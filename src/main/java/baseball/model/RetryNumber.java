package baseball.model;

import baseball.view.InputView;

public class RetryNumber {
    private String retryNumber;

    public String getRetryNumber(){

        return retryNumber;
    }

    public RetryNumber(String retryNumber) {
        isCorrectRetryNumber(retryNumber);
        this.retryNumber = retryNumber;
    }

    public static void isCorrectRetryNumber(String number) throws IllegalArgumentException {
        if (!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}