package baseball.model;

import java.util.List;

public class Player {

    private GuessNumber guessNumber;
    private GameStateNumber gameStateNumber;

    public Player() {
        this.guessNumber = new GuessNumber();
        this.gameStateNumber = GameStateNumber.DEFAULT;
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
        return gameStateNumber.isExit();
    }
}
