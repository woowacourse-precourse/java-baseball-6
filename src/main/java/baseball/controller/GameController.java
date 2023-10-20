package baseball.controller;

import baseball.domain.GameResult;
import baseball.service.GameService;
import baseball.validator.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;
    public GameController(GameService gameService,InputView inputView,OutputView outputView) {
        this.gameService = gameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        gameInit();
        gamePlay();
    }

    private void gamePlay() {
        String inputNumbers = inputView.inputNumbers();
        Validator.isValidNumbers(inputNumbers);
        GameResult result = gameService.getResult(inputNumbers);
        outputView.outputResult(result);
    }

    private void gameInit() {
        gameService.numbersInit();
    }

}
