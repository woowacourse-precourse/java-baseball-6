package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final GameService gameService;
    private final OutputView outputView;

    public GameController() {
        gameService = new GameService();
        outputView = new OutputView();
    }

    public void start(){
        outputView.start();
    }

    public void play(String input){
        gameService.setUserbaseballNumber(input);
    }
}
