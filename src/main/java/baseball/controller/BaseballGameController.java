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
        ComputerNumber computerNumber = new ComputerNumber();
        do {
            compareUserToComputer(computerNumber.getComputerNumber());
            OutputView.printClearMessage();
            input = InputView.inputUserRestartMessage();
        } while (isGameRestart(input));
    }

    private boolean isGameRestart(String input) {
        return input.equals(Constant.GAME_RESTART_NUMBER);
    }

    private void compareUserToComputer(List<Integer> computerNumber) {
        BaseballGameResult gameResult;
        do {
            System.out.println(computerNumber);
            String input = InputView.inputUserNumberMessage();
            gameResult = new BaseballGameResult(computerNumber, new UserNumber(input));
            new OutputView(gameResult).printGameResult();
        } while (!isGameClear(gameResult.strikeCount));
    }

    private boolean isGameClear(int strikeCount) {
        return strikeCount == CLEAR_NUMBER;
    }
}
