package baseball;

import baseball.generator.NumberGenerator;
import baseball.handler.OutputHandler;
import baseball.handler.InputHandler;

public class Game {

    private final InputHandler inputHandler = new InputHandler();
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final OutputHandler outputHandler = new OutputHandler();
    private boolean isGameOver;

    public Game() {
        this.isGameOver = false;
        outputHandler.printGameStartMessage();
    }

    public void play() {
        String computerNumber = numberGenerator.generateRandomNumber();
        while (!isGameOver) {
            String userInputNumber = inputHandler.askUserInputNumber();
            isGameOver = outputHandler.printResultMessage(userInputNumber, computerNumber);
        }
    }

    public boolean isRestart() {
        isGameOver = false;
        return inputHandler.askRestart();
    }
}
