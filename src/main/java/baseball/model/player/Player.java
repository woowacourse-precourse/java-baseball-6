package baseball.model.player;

import java.util.List;

public class Player {

    private GuessNumber guessNumber;
    private GameStateNumber gameStateNumber;

    public Player(GuessNumber guessNumber, GameStateNumber gameStateNumber) {
        this.guessNumber = guessNumber;
        this.gameStateNumber = gameStateNumber;
    }

    public void inputGuessNumber() {
        guessNumber.input();
    }

    public void inputGameStateNumber() {
        gameStateNumber.input();
    }

    public List<Integer> getGuessNumbers() {
        return guessNumber.getNumbers();
    }

    public boolean continueGame() {
        return !gameStateNumber.isExit();
    }
}
