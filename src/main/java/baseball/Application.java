package baseball;

import baseball.baseballGame.BaseballGame;
import baseball.game.UserController;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        UserController userController = new UserController(baseballGame);
        userController.run();
    }
}
