package baseball.controller;

import static baseball.view.GameView.gameEndView;
import static baseball.view.GameView.gameResultView;
import static baseball.view.GameView.gameStartView;
import static baseball.view.GameView.restartOrExitView;
import static baseball.view.GameView.userInputView;

import baseball.domain.GameRestartOrExit;
import baseball.domain.GameResult;
import baseball.domain.Number;
import camp.nextstep.edu.missionutils.Console;

/**
 * 게임 동작 흐름 제어 클래스
 */

public class GameController {
    private final Number computerNumber = new Number();
    private final Number userNumber = new Number();
    private final GameResult gameResult = new GameResult();
    private final GameRestartOrExit gameRestartOrExit = new GameRestartOrExit();

    public void gameRun() {
        do {
            computerNumber.createComputerNumber();
            gameStartView();
            oneGamePlay();
        } while (restartOrExit());
    }

    private void oneGamePlay() {
        do {
            userInputView();
            userNumber.inputUserNumber(Console.readLine());
            userNumber.inputCheck(computerNumber, gameResult);
            gameResultView(gameResult);
        } while (gameResult.gameEnd());
    }

    private boolean restartOrExit() {
        gameEndView();
        restartOrExitView();
        gameRestartOrExit.gameRestartOrValueInput(Console.readLine());
        return gameRestartOrExit.restartOrExitCheck();
    }
}
