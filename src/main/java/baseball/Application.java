package baseball;

import baseball.game.BaseballGame;
import baseball.game.impl.BaseballGameImpl;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGameImpl(3);
        while (!game.isOver()) {

        }
    }
}
