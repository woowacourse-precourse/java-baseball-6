package baseball.controller;

public class MainController {
    public static MainController instance = new MainController(GameRestartController.getInstance(), GamePlayController.getInstance());
    private final GameRestartController gameRestartController;
    private final GamePlayController gamePlayController;

    private MainController(GameRestartController gameRestartController, GamePlayController gamePlayController) {
        this.gameRestartController = gameRestartController;
        this.gamePlayController = gamePlayController;
    }

    public static MainController getInstance() {
        return instance;
    }

    public void run() {
        boolean continuePlaying = true;
        while (continuePlaying) {
            if (!gamePlayController.play()) {
                continuePlaying = gameRestartController.wantsRestart();
            }
        }
    }
}