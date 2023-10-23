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
        int restartOrExitNumber = 0;
        while (restartOrExitNumber != 2) {
            outputView.printGameStartMessage();
            List<Integer> computerNumber = gameService.createComputerNumber();
            new ComputerNumber(computerNumber);
            String compareResult = "";
            while (!compareResult.equals("3스트라이크")) {
                outputView.printInputNumberMessage();
                List<Integer> userNumber = inputView.inputUserNumber();
                new UserNumber(userNumber);
                compareResult = gameService.getCompareResult(computerNumber, userNumber);
                outputView.printCompareResult(compareResult);
            }
            outputView.printGameOverMessage();
            outputView.printGameContinueMessage();
            restartOrExitNumber = inputView.inputRestartOrExitNumber();
            new RestartOrExitNumber(restartOrExitNumber);
        }
    }
}
