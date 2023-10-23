package baseball.controller;

import baseball.service.BaseballService;
import baseball.service.ComputerService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballController {
    private final BaseballService baseballService = new BaseballService();
    private final ComputerService computerService = new ComputerService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.startGame();
        gameStart();
    }

    public void gameStart() {
        List<Integer> randomNumber = computerService.createRandomNumber();
        baseballService.baseballGameStart(randomNumber);
    }
}
