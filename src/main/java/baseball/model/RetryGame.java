package baseball.model;

public class RetryGame {

    private String retryNum;

    public String getRetryNumber() {
        return retryNum;
    } // 외부에서 쓰려는 getter

    public RetryGame(String retryNum) {
        isCorrectRetryNumber(retryNum); // 제대로 누르면 아무런 작동 x
        this.retryNum = retryNum;
    }

    // 1이나 2 안 누를 경우 에러
    public static void isCorrectRetryNumber(String number) throws IllegalArgumentException {
        if (!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException("에러! 1과 2만 입력할 수 있습니다.");
        }
    }
}
