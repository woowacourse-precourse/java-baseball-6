package baseball;

import baseball.model.BaseballGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame game = BaseballGame.createBaseballGame();
        game.run();

    }
}
