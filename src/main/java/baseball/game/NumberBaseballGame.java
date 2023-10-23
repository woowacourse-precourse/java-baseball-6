package baseball.game;

public class NumberBaseballGame {
    private final Computer computer;
    private GameNumbers answer;

    public NumberBaseballGame() {
        this.computer = new Computer();
    }

    public void run() {
        setGame();
        playGame();
        endGame();
    }

    private void setGame() {
        answer = computer.generateAnswer();
    }

    private void playGame() {

    }

    private void endGame() {

    }
}
