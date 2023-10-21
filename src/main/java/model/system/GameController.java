package model.system;

import java.util.List;
import model.player.Computer;
import model.referee.GameScoreboard;
import utils.BaseballNumberUtils;

public class GameController {

    public GameController() {
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
