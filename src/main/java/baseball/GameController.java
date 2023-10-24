package baseball;

import camp.nextstep.edu.missionutils.Console;
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
            playGame();
        } while (view.selectMenu() == 1);

        Console.close();
    }

    void startGame() {
        view.startGame();
        model.startGame();
    }

    void playGame() {
        int[] scores;
        int ball, strike;

        do {
            String answer = view.enterAnswer();
            scores = model.markAnswer(answer);
            ball = scores[0];
            strike = scores[1];
            view.markAnswer(ball, strike);
        } while (strike != 3);
    }
}
