package baseball.baseballV1.controller;

import baseball.baseballV1.model.Game;
import baseball.baseballV1.model.Player;
import baseball.baseballV1.model.TripleBalls;
import baseball.baseballV1.util.Constants;
import baseball.baseballV1.util.Util;
import baseball.baseballV1.view.InputView;
import baseball.baseballV1.view.OutputView;

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
