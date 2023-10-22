package baseball.controller;

import baseball.service.BaseBallService;
import baseball.service.SystemService;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseBallController {
    private BaseBallService baseBallService = new BaseBallService();
    private SystemService systemService = new SystemService();

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            List<Integer> computerNum = systemService.generateComputerNum();
            baseBallService.init(computerNum);
            baseBallService.start();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while (systemService.restart(Console.readLine()));
    }
}
