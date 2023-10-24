package baseball.controller;

import baseball.config.DiContainer;

public class ComputerController implements Controller {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    @Override
    public void gameStart() {
        System.out.println(GAME_START_MESSAGE);
        new DiContainer().userController().gameStart();
    }
}

