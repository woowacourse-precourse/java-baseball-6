package baseball;

import baseball.domain.controller.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game.getInstance().start();
    }
}
