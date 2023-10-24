package baseball;

import baseball.game.generator.NumberGenerator;
import baseball.game.handler.OutputHandler;
import baseball.game.handler.InputHandler;

public class BaseballGame {

    private final InputHandler inputHandler = new InputHandler();
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final OutputHandler outputHandler = new OutputHandler();
    private boolean isGameOver;

    public BaseballGame() {
        this.isGameOver = false;
        outputHandler.printGameStartMessage();
    }

    public void play() {
        String computerBaseballNumber = numberGenerator.generateRandomBaseballNumber();
        while (!isGameOver) {
            String userBaseballNumber = inputHandler.askUserBaseballNumber();
            isGameOver = outputHandler.printResultMessage(userBaseballNumber, computerBaseballNumber);
        }
    }

    public boolean isRestart() {
        isGameOver = false;
        return inputHandler.askRestart();
    }
}
