package baseball.controller;

import baseball.model.ComputerNumber;
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
        }
    }

    private List<Integer> getComputerNumber() {
        List<Integer> computerNumber = gameService.createComputerNumber();
        new ComputerNumber(computerNumber);
        return computerNumber;
    }
}
