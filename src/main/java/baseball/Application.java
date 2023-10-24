package baseball;

import baseball.game.BaseballGame;
import baseball.game.GameInstance;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame.getInstance().process();
    }
}
