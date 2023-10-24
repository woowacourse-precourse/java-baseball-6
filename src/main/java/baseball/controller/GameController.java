package baseball.controller;

import baseball.domain.NumberBaseball;
import baseball.service.GameService;
import baseball.service.GameServiceImpl;
import baseball.view.*;

public class GameController {

    private StartView startView;
    private InputView inputView;
    private HintView hintView;
    private GameService gameService;

    public GameController(StartView startView, InputView inputView, HintView hintView,
                          GameService gameService) {
        this.startView = startView;
        this.inputView = inputView;
        this.hintView = hintView;
        this.gameService = gameService;
    }

    public void play() {
        while (true) {
            startView.displayStartMessage();

            //컴퓨터는 서로 다른 숫자로 이루어진 3자리 숫자 1개를 뽑음　
            NumberBaseball computerBaseball = NumberBaseball.createRandomBaseball();
            gameService.playOneGame();

        }
    }


}