package baseball;

public class Game {
    private final String answer;
    private String gameInput;
    private int[] result;
    private boolean gameOver = false;

    public Game(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getGameInput() {
        return gameInput;
    }

    public int[] getResult() {
        return result;
    }

    public void setGameInput(String userInput) {
        this.gameInput = userInput;
    }

    public void setResult(int[] result) {
        this.result = result;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
