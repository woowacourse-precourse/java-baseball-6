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
        outputView.gameStart();
        this.gameService = gameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        gameInit();
        gamePlay();
        gameEndOrRestart();
    }

    private void gameEndOrRestart() {
        outputView.gameSuccess();
        String option = inputView.endOrRestartInput();
        Validator.isValidGameOption(option);
        if (isRestart(option)) {
            gameService.restart();
            run();
        }
    }

    private boolean isRestart(String option) {
        return option.equals("1");
    }


    private void gamePlay() {
        String inputNumbers = inputView.inputNumbers();
        Validator.isValidNumbers(inputNumbers);
        GameResult result = gameService.getResult(inputNumbers);
        outputView.outputResult(result);
        if (!isSuccess(result)) {
            gamePlay();
        }
    }

    private boolean isSuccess(GameResult result) {
        return result.getStrike() == 3;
    }

    private void gameInit() {
        gameService.numbersInit();
    }

}
