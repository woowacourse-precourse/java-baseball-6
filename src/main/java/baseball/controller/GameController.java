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
    private InputView inputView;
    private OutputView outputView;

    {
        gameService = new GameService();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void playGame() {
        int restartOrExitNumber = 1;
        while (restartOrExitNumber != 2) {
            outputView.printGameStartMessage();
            List<Integer> computerNumber = getComputerNumber();
            playOneGame(computerNumber);
            printGameOverAndContinueMessage();
            restartOrExitNumber = getRestartOrExitNumber();
        }
    }

    private List<Integer> getComputerNumber() {
        List<Integer> computerNumber = gameService.createComputerNumber();
        new ComputerNumber(computerNumber);
        return computerNumber;
    }

    private void playOneGame(List<Integer> computerNumber) {
        String compareResult = "";
        while (!compareResult.equals("3스트라이크")) {
            outputView.printInputNumberMessage();
            List<Integer> userNumber = getUserNumber();
            compareResult = gameService.getCompareResult(computerNumber, userNumber);
            outputView.printCompareResult(compareResult);
        }
    }

    private List<Integer> getUserNumber() {
        List<Integer> userNumber = inputView.inputUserNumber();
        new UserNumber(userNumber);
        return userNumber;
    }

    private void printGameOverAndContinueMessage() {
        outputView.printGameOverMessage();
        outputView.printGameContinueMessage();
    }

    private int getRestartOrExitNumber() {
        int restartOrExitNumber = inputView.inputRestartOrExitNumber();
        new RestartOrExitNumber(restartOrExitNumber);
        return restartOrExitNumber;
    }
}
