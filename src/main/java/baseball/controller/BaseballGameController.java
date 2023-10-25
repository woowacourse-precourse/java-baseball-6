package baseball.controller;

import baseball.constant.Constant;
import baseball.domain.BaseballGameResult;
import baseball.domain.ComputerNumber;
import baseball.domain.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameController {

    private static final int CLEAR_NUMBER = 3;

    public BaseballGameController() {
        OutputView.printStartMessage();
    }

    public void gamePlay() {
        gameProcess();
    }

    private void gameProcess() {
        String input;
        do {
            List<Integer> computerNumber = new ComputerNumber().getComputerNumber();
            compareUserToComputer(computerNumber);
            OutputView.printClearMessage();
            input = InputView.inputUserRestartMessage();
        } while (validateGameRestart(input));
    }

    private boolean validateGameRestart(String input) {
        return input.equals(Constant.GAME_RESTART_NUMBER);
    }

    private void compareUserToComputer(List<Integer> computerNumber) {
        BaseballGameResult gameResult;
        do {
            String input = InputView.inputUserNumberMessage();
            List<Integer> userNumber = new UserNumber(input).getUserNumber();
            gameResult = new BaseballGameResult(computerNumber, userNumber);
            new OutputView(gameResult).printGameResult();
        } while (!validateGameClear(gameResult.strikeCount));
    }

    private boolean validateGameClear(int strikeCount) {
        return strikeCount == CLEAR_NUMBER;
    }
}
