package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.RestartOrExitNumber;
import baseball.model.UserNumber;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private GameService gameService;

    {
        gameService = new GameService();
    }

    public void playGame() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        int restartOrExitNumber = 1;
        while (restartOrExitNumber != 2) {
            outputView.printGameStartMessage();
            List<Integer> computerNumber = getComputerNumber();
            playOneGame(computerNumber, outputView, inputView);
            printGameOverAndContinueMessage(outputView);
            restartOrExitNumber = getRestartOrExitNumber(inputView);
        }
    }

    private List<Integer> getComputerNumber() {
        List<Integer> computerNumber = gameService.createComputerNumber();
        new ComputerNumber(computerNumber);
        return computerNumber;
    }

    private void playOneGame(List<Integer> computerNumber, OutputView outputView, InputView inputView) {
        String compareResult = "";
        while (!compareResult.equals("3스트라이크")) {
            outputView.printInputNumberMessage();
            List<Integer> userNumber = getUserNumber(inputView);
            compareResult = gameService.getCompareResult(computerNumber, userNumber);
            outputView.printCompareResult(compareResult);
        }
    }

    private List<Integer> getUserNumber(InputView inputView) {
        List<Integer> userNumber = inputView.inputUserNumber();
        new UserNumber(userNumber);
        return userNumber;
    }

    private void printGameOverAndContinueMessage(OutputView outputView) {
        outputView.printGameOverMessage();
        outputView.printGameContinueMessage();
    }

    private int getRestartOrExitNumber(InputView inputView) {
        int restartOrExitNumber = inputView.inputRestartOrExitNumber();
        new RestartOrExitNumber(restartOrExitNumber);
        return restartOrExitNumber;
    }
}
