package baseball.controller;

import baseball.model.Game;
import baseball.model.Player;
import baseball.model.TripleBalls;
import baseball.util.Util;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private Player registeringPlayer;
    private TripleBalls registeredComputer;

    public GameController() {
        InputView.displayGameStart();
        init();
    }

    private void init() {
        registeringPlayer = registerPlayer();
        if (registeringPlayer == null) {
            return;
        }
        startGame(new Game());
    }

    private void startGame(Game game) {
        // 맞출때까지 반복해야 한다
        // Computer 도 난수로 생성해야 한다
        registeredComputer = Util.generateComputerTripleBalls();
        while (!registeringPlayer.hasSameBalls(registeredComputer)) {
            // refactoring 구간 1
            // 대안) Player 타입의 컴퓨터로 변화 -> game comparePlayers(playerA, playerB)
            System.out.println(game.checkTripleBalls(registeringPlayer.getPlayerTripleBalls(), registeredComputer));
            registeringPlayer = registerPlayer();
        }

        OutputView.displayThreeStrikes();
        finishOrRestartGame(InputView.inputRestartOrFinish());
    }

    private Player registerPlayer() {
        return InputController.generatePlayerTripleBalls(InputView.getPlayerInput());
    }

    private void finishOrRestartGame(String inputGameRestart) {
        if (inputGameRestart.equals("1")) {
            init();
            return;
        }
        finishGame();
    }

    private void finishGame() {
        return;
    }
}
