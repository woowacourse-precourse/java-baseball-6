package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private List<GameController> gameControllerList;

    private void init() {
        gameControllerList = new ArrayList<>();
        gameControllerList.add(new BaseballGameController(true));
    }

    public void start() {
        init();
        for (GameController gameController : gameControllerList) {
            if (gameController.isRunning) {
                gameController.start();
            }
        }
    }
}
