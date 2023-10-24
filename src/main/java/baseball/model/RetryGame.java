package baseball.model;

public class RetryGame {

    private String retryNum;

    public String getRetryNumber() {
        return retryNum;
    }

    public RetryGame(String retryNum) {
        this.retryNum = retryNum;
        isCorrectRetryNumber(retryNum);
    }

    public static void isCorrectRetryNumber(String number) throws IllegalArgumentException {
        if (!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException("에러! 1과 2만 입력할 수 있습니다.");
        }
    }
}
