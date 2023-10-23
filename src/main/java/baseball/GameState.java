package baseball;

public class GameState {
    private boolean gameOver;
    private int attemptCount;
    private String answer;

    public GameState(String getResult) {
        this.gameOver = false;
        this.answer = answer;
    }

    public boolean isGameOver() {
        return gameOver;
    }


    public String getAnswer() {
        return answer;
    }
}
