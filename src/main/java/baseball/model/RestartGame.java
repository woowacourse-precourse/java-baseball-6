package baseball.model;

public class RestartGame {
    private String restartNumber;

    public RestartGame(String number) {
        isCorrectRestart(number);
        this.restartNumber = number;
    }

    public String getRestartNumber() {
        return this.restartNumber;
    }

    public static void isCorrectRestart(String number) throws IllegalArgumentException {
        if (!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
