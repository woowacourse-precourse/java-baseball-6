package baseball.controller;

import java.util.List;

public class MainController {
    private List<GameController> gameControllerList;

    private void init() {
        gameControllerList.add(new BaseballGameController(true));
    }

    public void start() {
        init();
        for (GameController gameController : gameControllerList) {
            gameController.start();
        }
    }
}
