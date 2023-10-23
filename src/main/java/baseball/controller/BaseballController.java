package baseball.controller;

import baseball.constant.Constant;
import baseball.model.BaseballGameResult;
import baseball.model.ComputerNumber;
import baseball.service.BaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

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
        List<Integer> computerNumber = new ComputerNumber().getNumber();
        do {
            String input = InputView.requestUserNumber();
            BaseballGameResult gameResult = baseballGameService.getGameResult(input, computerNumber);
            ball = gameResult.getBall();
            strike = gameResult.getStrike();
            resultGame();
        } while (strike != Constant.MAX_STRIKE);
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
