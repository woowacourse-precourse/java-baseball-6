package baseball;

import baseball.constant.Status;
import baseball.constant.SystemMessage;

public class GameController {

    public static Status gameStatus = Status.NEW;

    public void startGame() {
        Game game = new Game();
        SystemMessage.NEW.printMessage(gameStatus);
        game.startGame();
        System.out.println(gameStatus);
        if (replayGame()) {
            game.startGame();
        }
    }

    private boolean replayGame(){
        System.out.println("GameController.replayGame");
        return gameStatus.equals(Status.GAME);
    }

}
