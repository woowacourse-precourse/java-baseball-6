package baseball;

import baseball.controller.GameController;
import baseball.service.GameService;
import baseball.service.GameServiceImpl;
import baseball.service.hint.*;
import baseball.view.*;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new StartView(),
                new InputView(),
                new HintView(),
                createGameService());

        gameController.play();
    }

    private static GameService createGameService() {
        GameService gameService = new GameServiceImpl(
                BallService.getInstance(),
                StrikeService.getInstance(),
                NothingService.getInstance()
        );
        return gameService;
    }
}