package baseball.Controller;

import baseball.Model.BaseBallGame;
import baseball.View.GameView;

public class GameController {
    private BaseBallGame baseBallGame;
    private GameView gameView;

    public GameController(BaseBallGame baseBallGame, GameView gameView) {
        this.baseBallGame = baseBallGame;
        this.gameView = gameView;
    }
    public void startGame() {

    }
}
