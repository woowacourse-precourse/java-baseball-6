package baseball.model;

public class RetryNumber {
    private String retryNumber;

    public String getRetryNumber() {

        return retryNumber;
    }

    public RetryNumber(String retryNumber) {
        isCorrectRetryNumber(retryNumber);
        this.retryNumber = retryNumber;
    }

    /**
     * 숫자는 1,2만 허용해야
     *
     * @param number
     */
    private void isCorrectRetryNumber(String number) {
        if (!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
