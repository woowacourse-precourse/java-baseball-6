package baseball.controller;

import baseball.domain.NumberBaseball;
import baseball.domain.Restart;
import baseball.service.GameService;
import baseball.service.hint.HintService;
import baseball.util.ExceptionUtil;
import baseball.util.InputUtil;
import baseball.validation.IntegerValidator;
import baseball.view.*;

public class GameController {

    private StartView startView;
    private InputView inputView;
    private HintView hintView;
    private EndView endView;
    private RestartView restartView;
    private HintService hintService;
    private GameService gameService;

    public GameController(StartView startView, InputView inputView, HintView hintView,
                          EndView endView, RestartView restartView,
                          HintService hintService, GameService gameService) {
        this.startView = startView;
        this.inputView = inputView;
        this.hintView = hintView;
        this.endView = endView;
        this.restartView = restartView;
        this.hintService = hintService;
        this.gameService = gameService;
    }

    public void play() {
        while (true) {
            startGame();
            if (restartGame()) {
                return;
            }
        }
    }

    private void startGame() {
        startView.displayStartMessage();

        NumberBaseball computerBaseball = NumberBaseball.createRandomBaseball();
        //System.out.println(computerBaseball.getValues());
        gameService.playOneGame(inputView, hintView, endView, restartView, hintService, computerBaseball);
    }

    private boolean restartGame(){
        restartView.displayRestartChoiceMessage();
        String regameNum = InputUtil.inputString();

        IntegerValidator.validateInteger(regameNum);
        int parsedRegameNum = Integer.parseInt(regameNum);
        Restart restart = RestartController.validateValue(parsedRegameNum);

        if (restart == Restart.RESTART_GAME) {
            return false;
        }
        if (restart == Restart.EXIT_GAME) {
            return true;
        }
        if (restart == Restart.OTHER_CHOICE) {
            ExceptionUtil.throwInvalidValueException();
        }
        return false;
    }
}