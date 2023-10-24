package model.system;

import model.player.Computer;
import model.player.User;
import model.referee.GameScoreboard;
import model.referee.Referee;

public final class GameStarter {

    public GameStarter() {
    }

    public GameScoreboard start(Computer computer, User user) {
        Referee referee = Referee.create(user, computer);
        GameScoreboard gameResult = referee.JudgeBaseBallGame();
        return gameResult;
    }


}
