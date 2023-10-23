package baseball.controller;

import baseball.model.Baseball;
import baseball.service.BaseballService;

public class BaseballController {

    private final BaseballService baseballService;

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    public void run() {
        boolean start = true;
        while (start) {
            Baseball answer = baseballService.createAnswerBaseball();
            playGame();
            start = isRestart();
        }
    }

    private void playGame() {
        //TODO Auto-generated
    }


    private boolean isRestart() {
        //TODO Auto-generated
        return false;
    }
}
