package baseball.controller;

import baseball.service.BaseballService;

public class BaseballController {

    /**
     * 초기 게임 세팅
     */
    public void init(){
        BaseballService service = new BaseballService();
        service.init();
    }
}
