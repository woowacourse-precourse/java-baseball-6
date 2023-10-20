package baseball.controller;

import baseball.service.GameService;
import baseball.validator.Validator;
import baseball.view.InputView;

public class GameController {

    private final GameService gameService;
    private final InputView inputView;
    public GameController(GameService gameService,InputView inputView) {
        this.gameService = gameService;
        this.inputView = inputView;
    }

    public void run() {
        gameInit();
        gamePlay();
    }

    private void gamePlay() {
        String inputNumbers = inputView.inputNumbers();
        Validator.isValidNumbers(inputNumbers);
        gameService.getResult(inputNumbers);
    }

    private void gameInit() {
        gameService.numbersInit();
    }

}
