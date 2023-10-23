package model.system;

import model.player.Computer;
import model.player.User;
import model.referee.GameScoreboard;

public final class GameController {
    private final GameStarter gameStarter;
    private final GameTerminator gameTerminator;

    public GameController(GameStarter gameStarter, GameTerminator gameTerminator) {
        this.gameStarter = gameStarter;
        this.gameTerminator = gameTerminator;
    }

    public GameScoreboard run(User user, Computer computer) {
        GameScoreboard gameScoreboard = gameStarter.start(computer, user);
        return gameScoreboard;
    }

    public boolean isRunning(GameScoreboard gameScoreboard) {
        return gameTerminator.isGameStillRunning(gameScoreboard);
    }

}
