package baseball.Controller;

import baseball.entity.Computer;

public class Controller {

    public static boolean run() { // 게임 시작의 요청을 받는 컨트롤러
        Computer computer = Computer.getInstance();
        computer.init();
        return true;
    }
}
