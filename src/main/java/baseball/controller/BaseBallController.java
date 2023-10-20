package baseball.controller;

import static baseball.converter.BaseBallConverter.stringToNumbers;
import static baseball.converter.BaseBallConverter.stringToOverallGameStatus;

import baseball.domain.number.Numbers;
import baseball.domain.result.Result;
import baseball.enums.OverallGameStatus;
import baseball.service.BaseBallService;
import baseball.view.BaseBallView;


public class BaseBallController {

    private static BaseBallView baseBallView;
    private static BaseBallService baseBallService;


    public static void run() {
        init();
        startMainGame();
    }

    private static void init() {
        baseBallView = BaseBallView.create();
        baseBallService = BaseBallService.create();
    }

    private static void startMainGame() {
        baseBallView.startGameView();

        OverallGameStatus overallGameStatus = OverallGameStatus.CONTINUE;

        while (overallGameStatus.isContinue()) {
            baseBallService.resetComputer();

            startSubGame();

            overallGameStatus = stringToOverallGameStatus(baseBallView.continueInputView());
        }
    }

    private static void startSubGame() {
        boolean isContinueGame = Boolean.TRUE;

        while (isContinueGame) {
            Numbers numbers = stringToNumbers(baseBallView.numbersInputView());
            baseBallService.humanNumberChange(numbers);

            Result result = baseBallService.calculateResult();
            baseBallView.resultGameView(result);

            isContinueGame = result.isContinue();
        }
    }

}
