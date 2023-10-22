package model.system;

import java.util.List;
import model.player.Computer;
import model.referee.GameScoreboard;
import utils.BaseballNumberUtils;

public final class GameController {

    private final GameStarter gameStarter;
    private final GameTerminator gameTerminator;

    public GameController(GameStarter gameStarter, GameTerminator gameTerminator) {
        this.gameStarter = gameStarter;
        this.gameTerminator = gameTerminator;
    }

    public void run() {
        final Computer computer = setupGame();
        GameScoreboard gameScoreboard;
        do {
            gameScoreboard = playGameRound(computer);
        } while (isGameRunning(gameScoreboard));
    }

    private Computer setupGame() {
        List<Integer> randomNumbers = BaseballNumberUtils.createRandomNumbers();
        return Computer.create(randomNumbers);
    }

    private boolean isGameRunning(GameScoreboard gameScoreboard) {
        return gameTerminator.isGameStillRunning(gameScoreboard);
    }

    private GameScoreboard playGameRound(Computer computer) {
        return gameStarter.start(computer);
    }

}
