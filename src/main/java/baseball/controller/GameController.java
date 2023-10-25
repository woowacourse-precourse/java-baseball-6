package baseball.controller;

import baseball.service.BaseballService;

public class GameController {
    public BaseballController baseballController = new BaseballController();
    public BaseballService baseballService = new BaseballService();
    public void Init() {
        baseballService.startNewGame();
        baseballController.readUserNumber();
    }

}
