package baseball.model.player;

import java.util.List;

public class Player {

    private GuessNumbers guessNumbers;
    private GameStateNumber gameStateNumber;

    public Player(GuessNumbers guessNumbers, GameStateNumber gameStateNumber) {
        this.guessNumbers = guessNumbers;
        this.gameStateNumber = gameStateNumber;
    }

    public void inputGuessNumbers() {
        guessNumbers.input();
    }

    public void inputGameStateNumber() {
        gameStateNumber.input();
    }

    public List<GuessNumber> getGuessNumbers() {
        return guessNumbers.getNumbers();
    }

    public boolean continueGame() {
        return !gameStateNumber.isExit();
    }
}
