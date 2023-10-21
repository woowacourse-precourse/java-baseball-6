package baseball.model;

import baseball.util.GameInputValid;

public class GameModel {

    private Computer computer;
    private GameInputValid gameInputValid;

    public GameModel(GameInputValid gameInputValid) {
        computer = new Computer();
        this.gameInputValid = gameInputValid;
    }

    public void validateUserInput(String input) throws IllegalArgumentException {
        gameInputValid.inputValid(input);
    }

}
