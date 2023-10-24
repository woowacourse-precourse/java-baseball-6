package baseball.controller;

import baseball.domain.GameResult;
import baseball.service.GameService;
import baseball.validator.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.constants.BaseballGameConstants.*;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        OutputView.gameStart();
        this.gameService = gameService;
    }

    public void run() {
        gameInit();
        gamePlay();
        gameEndOrRestart();
    }

    private void gameEndOrRestart() {
        OutputView.gameSuccess();
        String option = InputView.endOrRestartInput();
        Validator.isValidGameOption(option);
        if (isRestart(option)) {
            gameService.restart();
            run();
        }
    }

    private boolean isRestart(String option) {
        return option.equals(RESTART_OPTION);
    }


    private void gamePlay() {
        String inputNumbers = InputView.inputNumbers();
        Validator.isValidNumbers(inputNumbers);
        GameResult result = gameService.getResult(inputNumbers);
        OutputView.outputResult(result);
        if (!isSuccess(result)) {
            gamePlay();
        }
    }

    private boolean isSuccess(GameResult result) {
        return result.isThreeStrike();
    }

    private void gameInit() {
        gameService.numbersInit();
    }

}
