package baseball.game;

import baseball.player.Players;
import baseball.util.Result;

public class Inning {
    private Players players;
    private Result result;

    public Inning() {
        this.players = new Players();
    }

    public void startInning() {
        players.createComputerNumber();
        players.createUserNumber();
    }

    private void endInning() {
    }
}
