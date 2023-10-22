package baseball.controller;

import baseball.model.Computer;
import baseball.view.OutputView;
import java.util.List;

public class NBGameController {
    public void start() {
        OutputView out = new OutputView();
        out.displayString("숫자 야구 게임을 시작합니다.");

        Computer computer = Computer.generateRandomNumber();

        out.displayList(computer.getComputerNumber());
    }
}
