package controller;

import static utils.GameConstant.GAME_RESTART_OR_QUIT_PROMPT;
import static utils.GameConstant.GAME_START_MESSAGE;
import static utils.GameConstant.GAME_WIN_MESSAGE;
import static utils.GameConstant.QUIT_GAME;

import model.system.GameController;
import view.InputView;
import view.OutputView;

public class NumberBaseballController {

    private final GameController gameController;

    public NumberBaseballController(GameController gameController) {
        this.gameController = gameController;
    }

    public void run() {
        startGame();
        do {
            playGame();
        } while (!isUserWantToQuit());
    }

    private void startGame() {
        OutputView.write(GAME_START_MESSAGE);
    }

    private void playGame() {
        gameController.run();
        OutputView.write(GAME_WIN_MESSAGE);
        OutputView.write(GAME_RESTART_OR_QUIT_PROMPT);
    }

    private boolean isUserWantToQuit() {
        String input = InputView.readInput();
        return input.equals(QUIT_GAME);
    }
}
