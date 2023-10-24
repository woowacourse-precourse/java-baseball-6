package baseball.game;

public class Game {
    private Inning inning;

    public void startGame() {
        inning = new Inning();

        inning.startInning();
    }

    public boolean checkRestart() {
        return false;
    }

    public void endGame() {
    }
}
