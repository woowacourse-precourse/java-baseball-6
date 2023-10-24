package baseball;

import baseball.constant.Status;
import baseball.constant.SystemMessage;

public class GameController {

    public static Status gameStatus = Status.NEW;

    public void startGame() {
        Game game = new Game();
        SystemMessage.NEW.printMessage(gameStatus);
        game.startGame();
        if (replayGame()) {
            game.startGame();
        }
    }

    private boolean replayGame() {
        return gameStatus.equals(Status.GAME);
    }

}
