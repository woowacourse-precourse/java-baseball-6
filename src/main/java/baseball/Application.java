package baseball;

import baseball.input.BaseBallGameUserInput;
import baseball.manager.BaseBallNumberManager;

public class Application {

    private static final BaseBallGame baseBallGame = new BaseBallGame(
        new BaseBallNumberManager(),
        new BaseBallNumberManager(),
        new BaseBallGameUserInput());

    public static void main(String[] args) {
        // TODO: 프로그램 구현'

        baseBallGame.startGame(3);
    }
}
