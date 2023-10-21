package baseball.model;

public class GuessResult {

    private String resultMessage;
    private GameStatus status;

    public GuessResult(String resultMessage, GameStatus status) {
        this.resultMessage = resultMessage;
        this.status = status;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public GameStatus getStatus() {
        return status;
    }
}
