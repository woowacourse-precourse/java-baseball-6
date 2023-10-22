package baseball.controller;

import baseball.model.BaseballGameResult;
import baseball.service.BaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class BaseballController {

    private final BaseballGameService baseballGameService = new BaseballGameService();
    private int ball;
    private int strike;

    public void run() {
        OutputView.startGame();
        do {
            start();

        } while (isRestart());

    }

    private void start() {
        baseballGameService.setComputerNumber();
        do {
            String input = InputView.requestUserNumber();
            BaseballGameResult gameResult = baseballGameService.getGameResult(input);
            ball = gameResult.getBall();
            strike = gameResult.getStrike();
            resultGame();
        } while (strike != 3);
    }

    private void resultGame() {
        if (ball != 0 && strike == 0) {
            OutputView.onlyBall(ball);
        }
        if (ball == 0 && strike != 0) {
            OutputView.onlyStrike(strike);
        }
        if (ball != 0 && strike != 0) {
            OutputView.ballAndStrike(ball, strike);
        }
        if (ball == 0 && strike == 0) {
            OutputView.nothing();
        }
    }

    private boolean isRestart() {
        OutputView.endGame();
        String input = InputView.requestRestartGame();
        return baseballGameService.wantRestart(input);
    }

}
