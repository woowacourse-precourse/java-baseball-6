package baseball.controller;

import baseball.service.BaseBallService;
import baseball.service.SystemService;
import java.util.List;

public class BaseBallController {
    private SystemService systemService = new SystemService();

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNum = systemService.generateComputerNum();
        BaseBallService.init(computerNum);

    }
}
