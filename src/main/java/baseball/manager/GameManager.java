package baseball.manager;

import static baseball.constant.Constants.GAME_START_MESSAGE;
import static baseball.constant.Constants.INPUT_RESTART;
import static baseball.constant.Constants.INPUT_RESTART_MESSAGE;

import baseball.io.InputHandler;
import baseball.io.OutputHandler;
import baseball.model.Baseball;
import baseball.model.Game;
import baseball.validation.InputValidation;

public class GameManager {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public GameManager() {
        inputHandler = new InputHandler();
        outputHandler = new OutputHandler();
    }

    public void play() {
        int restart;
        outputHandler.printMessage(GAME_START_MESSAGE);
        do {
            Game game = new Baseball(inputHandler, outputHandler);
            game.initGame();
            game.playGame();
            outputHandler.printMessage(INPUT_RESTART_MESSAGE);
            restart = inputHandler.scanInteger();
            InputValidation.validRestartInput(restart);
        } while (restart == INPUT_RESTART);
    }
}
