package baseball.controller;

import baseball.service.BaseballGameService;

public class BaseballGameController {

    private BaseballGameService baseballGameService = new BaseballGameService();
    public void execute(){
        baseballGameService.start();
    }
}
