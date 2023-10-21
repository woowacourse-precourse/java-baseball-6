package model.system;

import java.util.List;
import model.player.Computer;
import model.referee.GameScoreboard;
import utils.BaseballNumberUtils;

public class GameController {

    private final GameStarter gameStarter;
    private final GameTerminator gameTerminator;

    public GameController(GameStarter gameStarter, GameTerminator gameTerminator) {
        this.gameStarter = gameStarter;
        this.gameTerminator = gameTerminator;
    }

    public void run() {
        boolean runningGame = true;
        List<Integer> randomNumbers = BaseballNumberUtils.createRandomNumbers();
        Computer computer = Computer.create(randomNumbers);
        while (runningGame) {
            GameScoreboard gameScoreboard = gameStarter.start(computer);
            runningGame = gameTerminator.isGameStillRunning(gameScoreboard);
        }
    }

}
