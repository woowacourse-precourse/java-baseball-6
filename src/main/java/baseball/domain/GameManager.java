package baseball.domain;

public class GameManager {
    private Integer balls;
    private Integer strikes;
    private boolean isNumberCorrect;

    public GameManager() {
        strikes = 0;
        balls = 0;
        isNumberCorrect = false;
    }
}
