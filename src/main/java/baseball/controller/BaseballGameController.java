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
            gameCycleProcess(computerNumber);
            OutputView.printClearMessage();
            System.out.println(InputView.INPUT_GAME_RESTART_MESSAGE);
            input = InputView.inputGameRestartMessage();
        } while (validateGameReplay(input));
    }

    private void gameCycleProcess(List<Integer> computerNumber) {
        BaseballGameResult gameResult;
        List<Integer> userNumber;
        do {
            System.out.println(computerNumber);
            System.out.print(InputView.INPUT_GAME_NUMBER_MESSAGE);
            String input = InputView.inputGameNumberMessage();
            userNumber = new UserNumber(input).getUserNumber();
            gameResult = new BaseballGameResult(computerNumber, userNumber);
            new OutputView(gameResult).printGameResult();
        } while (!validateGameClear(gameResult.strikeCount));
    }

    private boolean validateGameClear(int strikeCount) {
        return strikeCount == CLEAR_NUMBER;
    }

    private boolean validateGameReplay(String input) {
        return input.equals(Constant.GAME_RESTART_NUMBER);
    }

}
