package baseball.controller;

import baseball.domain.NumberBaseball;
import baseball.domain.RestartOption;
import baseball.service.GameService;
import baseball.service.hint.HintService;
import baseball.util.InputUtil;
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
        while (start()) {

        }
    }

    private boolean start() {
        startView.displayStartMessage();

        NumberBaseball computerBaseball = NumberBaseball.createRandomBaseball();
        //System.out.println(computerBaseball.getValues());
        gameService.playOneGame(inputView, hintView, endView, restartView, hintService, computerBaseball);

        return isRestart();
    }

    private boolean isRestart() {
        restartView.displayRestartChoiceMessage();

        String regameNum = InputUtil.inputString();
        RestartOption restartOption = RestartOption.create(regameNum);

        return restartOption == RestartOption.RESTART_GAME;
    }
}