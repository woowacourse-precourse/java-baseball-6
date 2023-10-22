package baseball.controller;

import baseball.service.BaseBallService;
import baseball.service.SystemService;
import java.util.List;

public class BaseBallController {
    private BaseBallService baseBallService = new BaseBallService();
    private SystemService systemService = new SystemService();

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        
        do {
            List<Integer> computerNum = systemService.generateComputerNum();
            baseBallService.init(computerNum);
        } while (baseBallService.start());
    }
}
