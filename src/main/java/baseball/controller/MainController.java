package baseball.controller;

public class MainController {
    public static MainController instance = new MainController(GamePlayController.getInstance(), GameRestartController.getInstance());
    private final GamePlayController gamePlayController;
    private final GameRestartController gameRestartController;

    private MainController(GamePlayController gamePlayController, GameRestartController gameRestartController) {
        this.gamePlayController = gamePlayController;
        this.gameRestartController = gameRestartController;
    }

    public static MainController getInstance() {
        return instance;
    }

    public void run() {
        boolean continuePlaying = true;
        while (continuePlaying) {
            if (!gamePlayController.playRound()) {
                continuePlaying = gameRestartController.wantsRestart();
            }
        }
    }
}