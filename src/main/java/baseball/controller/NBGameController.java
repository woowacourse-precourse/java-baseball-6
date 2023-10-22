package baseball.controller;

import baseball.model.Computer;
import baseball.view.OutputView;

public class NBGameController {
    public void start() {
        OutputView out = new OutputView();
        out.print("숫자 야구 게임을 시작합니다.");

        Computer computer = Computer.generateRandomNumber();

        out.print(computer.getComputerNumber());
    }
}
