package baseball.controller;

import baseball.domain.Game;

public class BaseballController {
    public void start() throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game();
        game.start();
    }
}
