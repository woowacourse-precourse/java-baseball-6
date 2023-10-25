package baseball.controller;

import baseball.service.BaseballGameService;

public class BaseballGameController {

    private final BaseballGameService baseballGameService = new BaseballGameService();
    public void execute(){
        baseballGameService.start();
    }
}
