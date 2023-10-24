package baseball.domain;

public class RestartNumber {
    private int restartNumber;

    public int getRestartNumber() {
        return restartNumber;
    }

    public RestartNumber(String restartNumber) {
        if (!restartNumber.equals("1") && !restartNumber.equals("2")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
        this.restartNumber = Integer.parseInt(restartNumber);
    }
}
