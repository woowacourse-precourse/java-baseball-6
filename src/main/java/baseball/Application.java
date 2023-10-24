package baseball;

import baseball.Util.MessageUtil;
import baseball.Util.Validator;
import baseball.controller.GameController;
import baseball.service.GameService;
import baseball.service.ScoreService;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new GameService(new ScoreService(), new Validator()), new MessageUtil());
        gameController.play();
    }
}
