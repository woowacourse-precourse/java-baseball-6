package baseball;

import baseball.Util.MessageUtil;
import baseball.Util.Validator;
import baseball.controller.GameController;
import baseball.service.GameService;
import baseball.service.ScoreService;
import baseball.service.UserService;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new UserService(new Validator()),
                new GameService(new ScoreService()),
                new MessageUtil());
        gameController.play();
    }
}
