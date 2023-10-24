package baseball.controller;

import baseball.config.DiContainer;

public class ComputerController implements Controller {

    @Override
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        new DiContainer().userController().gameStart();
    }
}

