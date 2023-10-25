package baseball.domain;

public class GameManager {
    private Integer balls;
    private Integer strikes;
    private boolean isNumberCorrect;
    private GameResult gameResult;
    public GameManager() {
        strikes = 0;
        balls = 0;
        isNumberCorrect = false;
        gameResult = new GameResult();
    }

    public void displayResult() {
        gameResult.displayResult();
    }
}
