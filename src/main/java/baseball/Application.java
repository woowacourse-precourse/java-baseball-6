package baseball;

import baseball.controller.GameController;
import baseball.service.GameServiceImpl;
import baseball.service.hint.HintService;
import baseball.service.hint.HintServiceImpl;
import baseball.service.hint.item.BallServiceImpl;
import baseball.service.hint.item.NothingServiceImpl;
import baseball.service.hint.item.StrikeServiceImpl;
import baseball.view.*;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new StartView(), //TODO: View를 GameController가 다 알아야할까?
                new InputView(),
                new HintView(),
                new EndView(),
                new RestartView(),
                createHintService(),
                new GameServiceImpl());

        gameController.play();
    }

    private static HintService createHintService() {
        HintService hintService = new HintServiceImpl(
                BallServiceImpl.getInstance(),
                StrikeServiceImpl.getInstance(),
                NothingServiceImpl.getInstance()
        );
        return hintService;
    }

}