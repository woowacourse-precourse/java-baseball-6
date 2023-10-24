package baseball;

import baseball.controller.GameController;
import baseball.service.GameService;
import baseball.service.GameServiceImpl;
import baseball.service.hint.item.BallServiceImpl;
import baseball.service.hint.item.NothingServiceImpl;
import baseball.service.hint.item.StrikeServiceImpl;
import baseball.view.*;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new StartView(),
                new InputView(),
                new HintView(),
                new EndView(),
                new RestartView(),
                createGameService());

        gameController.play();
    }

    private static GameService createGameService() {
        GameService gameService = new GameServiceImpl(
                BallServiceImpl.getInstance(),
                StrikeServiceImpl.getInstance(),
                NothingServiceImpl.getInstance()
        );
        return gameService;
    }
}