package baseball.controller;

import baseball.view.GameInput;
import baseball.view.GameOutput;

public class GameController {
    private static final String RESTART_FLAG = "1";
    private static final String END_FLAG = "2";
    private boolean state;
    PlayController playController;
    ValidateController validateController;
    GenerateController generateController;
    GameInput gameInput;
    GameOutput gameOutput;

    public GameController() {
        this.generateController = new GenerateController();
        this.validateController = new ValidateController();
        this.playController = new PlayController(this.generateController);
        this.gameInput = new GameInput();
        this.gameOutput = new GameOutput();

        state = true;
    }

    public void startGame() {
        while (state) {
            gameOutput.printStartGame();
            playController.generateNumber();
            guessNumber();
            state = endOrRestart();
        }
    }


}
