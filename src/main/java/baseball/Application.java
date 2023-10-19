package baseball;

import baseball.controller.GameController;
import baseball.controller.NumberBaseballGameController;
import baseball.service.NumberBaseballGameService;
import baseball.view.NumberBaseballView;

public class Application {

    public static void main(String[] args) {

        GameController gameController = new NumberBaseballGameController(
                new NumberBaseballGameService(),
                new NumberBaseballView()
        );

        gameController.run();
    }
}
