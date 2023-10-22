package baseball.controller;

import baseball.model.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NBGameController {
    public void start() {
        InputView in = new InputView();
        OutputView out = new OutputView();
        // 게임 시작 메세지 출력하기
        out.displayString("숫자 야구 게임을 시작합니다.");
        // 숫자 생성하기
        Computer computer = Computer.generateRandomNumber();
        out.displayList(computer.getComputerNumber());
        // 사용자로부터 console 입력 받기
        String user = in.inputString();
        out.displayString(user);
    }
}
