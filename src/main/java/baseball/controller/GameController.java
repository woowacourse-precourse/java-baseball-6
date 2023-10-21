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

public class GameController {
    private final Number computerNumber = new Number();

    public void gameRun() {
        do {
            computerNumber.createComputerNumber();
            gameStartView();
            oneGamePlay();
        } while (restartOrExit());
    }

    //한 게임
    private void oneGamePlay() {
        GameResult gameResult;
        do {
            userInputView();
            Number userNumber = new Number(Console.readLine());
            gameResult = userNumber.inputCheck(computerNumber);
            gameResultView(gameResult);
        } while (gameResult.gameEnd());
    }


    private boolean restartOrExit() {
        gameEndView();
        restartOrExitView();
        GameRestartOrExit restartOrExit = new GameRestartOrExit(Console.readLine());
        return restartOrExit.restartOrExitCheck();
    }
}
