package baseball;

import baseball.Util.MessageUtil;
import baseball.Util.Validator;
import baseball.controller.GameController;
import baseball.service.GameService;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new GameService(new Validator()), new MessageUtil());
        gameController.play();
    }
}
