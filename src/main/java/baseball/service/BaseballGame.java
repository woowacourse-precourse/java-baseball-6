package baseball.service;

import baseball.io.InputHandler;
import baseball.io.OutputHandler;
import baseball.model.CompareResult;
import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;

public class BaseballGame {

    private final ComputerNumber computerNumber;
    private Boolean isCorrect = false;

    public BaseballGame() {
        this.computerNumber = new ComputerNumber();
    }

    public void start() {
        do {
            PlayerNumber playerNumber = InputHandler.getPlayerNumber();
            CompareResult result = NumberChecker.compare(computerNumber.getValue(), playerNumber.getValue());
            OutputHandler.printCompareResult(result);

            if (result.getStrike() == 3) {
                setCorrect(true);
            }
        } while (!isCorrect);
        gameover();
    }

    private void gameover() {
        OutputHandler.printGameOver();
    }

    private void setCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
