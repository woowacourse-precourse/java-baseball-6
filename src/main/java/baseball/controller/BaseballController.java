package baseball.controller;

import baseball.model.BallChecker;
import baseball.model.BallThrower;
import baseball.valueObject.BallInfo;
import baseball.valueObject.ResultBall;
import baseball.view.FinishContinueView;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    public static void StartBaseballGame() {
        BallChecker ballChecker = new BallChecker(BallThrower.ThrowBall());

        while (ballChecker.isContinue()) {
            BallInfo ballInfo = InputView.getBallFromUserInput();
            ResultBall resultBall = ballChecker.getBallInfo(ballInfo);
            OutputView.printResult(resultBall);
        }

        if (FinishContinueView.finishOrContinueGame()) {
            StartBaseballGame();
        }
    }
}
