package baseball;

import baseball.Interface.UserInterface;
import baseball.game.BaseballGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame();
        UserInterface userInterface = new UserInterface(baseballGame);
        userInterface.start();
    }
}
