package baseball;

import baseball.config.Configuration;
import baseball.controller.GameController;

public final class Application {

    public static void main(final String[] args) {
        final GameController gameController = Configuration.createUniqueGameController();
        gameController.play();
    }
}
