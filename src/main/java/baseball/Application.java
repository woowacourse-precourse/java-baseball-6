package baseball;

import baseball.controller.BaseballGame;
import baseball.service.GameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame(new GameService());
        baseballGame.start();
    }
}
