package baseball.Controller;

import baseball.entity.Computer;
import baseball.service.Service;
import baseball.view.Input;
import baseball.view.Log;
import camp.nextstep.edu.missionutils.Console;

public class Controller {

    private final Service service;

    public Controller() {
        service = new Service();
    }

    public boolean run() { // 게임 시작의 요청을 받는 컨트롤러
        Computer computer = Computer.getInstance();
        computer.init();
        service.startGame();
        return Input.readExitNumber();
    }
}
