package baseball.controller;

import baseball.service.BaseBallService;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallController {
    private final BaseBallService service = new BaseBallService();
    public void doBaseBall(){
        service.mainStream();
    }
}
