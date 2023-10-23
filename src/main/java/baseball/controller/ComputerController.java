package baseball.controller;

import baseball.config.DiContainer;

public class ComputerController {

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        new DiContainer().userController().gameStart();
    }
}

