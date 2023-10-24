package baseball;

import java.util.logging.Logger;

public class GameController {

    public static final String LOGGERNAME = "GameLogger";

    Logger log = Logger.getLogger(LOGGERNAME);

    private static GameController gameController;
    GameView view;
    GameModel model;

    private GameController() {
    }

    public static GameController getInstance() {
        if (gameController == null) {
            gameController = new GameController();
        }
        return gameController;
    }

    void runGame() {
        view = GameView.getInstance();
        model = GameModel.getInstance();

        do {
            startGame();
            // TODO: playGame 구현
            break;
        } while (view.selectMenu() == 1);
    }

    void startGame() {
        view.startGame();
        model.startGame();
    }
}
