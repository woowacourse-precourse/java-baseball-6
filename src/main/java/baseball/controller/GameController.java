package baseball.controller;

import baseball.domain.NumberBaseball;
import baseball.service.GameService;
import baseball.view.*;

public class GameController {

    private StartView startView;
    private InputView inputView;
    private HintView hintView;
    private EndView endView;
    private RestartView restartView;
    private GameService gameService;

    public GameController(StartView startView, InputView inputView, HintView hintView,
                          EndView endView, RestartView restartView, GameService gameService) {
        this.startView = startView;
        this.inputView = inputView;
        this.hintView = hintView;
        this.endView = endView;
        this.restartView = restartView;
        this.gameService = gameService;
    }

    public void play() {
        while (true) {
            startView.displayStartMessage();

            //컴퓨터는 서로 다른 숫자로 이루어진 3자리 숫자 1개를 뽑음　
            NumberBaseball computerBaseball = NumberBaseball.createRandomBaseball();
            gameService.playOneGame(inputView, hintView, endView, restartView, computerBaseball);

        }
    }


}