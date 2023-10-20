package baseball.controller;

import baseball.model.Game;
import baseball.model.Player;
import baseball.model.TripleBalls;
import baseball.util.Constants;
import baseball.util.Util;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private Player registeringPlayer;
    private TripleBalls registeredComputer;

    public GameController() {
        init();
    }

    private void init() {
        InputView.displayGameStart();
        registeringPlayer = registerPlayer();
        startGame();
    }

    private void startGame() {
        Game game = new Game();
        registeredComputer = Util.generateComputerTripleBalls();

        while (!registeringPlayer.hasSameBalls(registeredComputer)) {
            displayResult(game);
            registeringPlayer = registerPlayer();
        }

        displayResult(game);
        OutputView.displayGameEnd();
        finishOrRestartGame(InputView.inputRestartOrFinish());
    }

    private void displayResult(Game game) {
        // refactoring 구간 1
        // 대안) Player 타입의 컴퓨터로 변화 -> game comparePlayers(playerA, playerB)
        OutputView.displaySentence(game.checkTripleBalls(registeringPlayer.getPlayerTripleBalls(), registeredComputer));
    }

    private Player registerPlayer() {
        return InputController.generatePlayerTripleBalls(InputView.getPlayerInput());
    }

    private void finishOrRestartGame(String inputGameRestart) {
        InputController.hasWrongInput(inputGameRestart);
        if (Util.hasSameInput(inputGameRestart, Constants.GAME_RESTART_NUMBER)) {
            init();
        }
        finishGame();
    }

    private void finishGame() {
        return;
    }
}
