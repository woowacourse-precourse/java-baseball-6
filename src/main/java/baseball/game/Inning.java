package baseball.game;

import baseball.player.Players;
import baseball.util.Result;

public class Inning {
    private Players players;
    private Result result;

    public Inning() {
        this.players = new Players();
        this.result = null;
    }

    public void startInning() {
        players.createComputerNumber();

        while (result == null || !result.isWin()) {
            players.createUserNumber();

            result = players.compareNumbers();

            result.checkResult();
        }
        endInning();
    }

    private void endInning() {
        result.printWin();
    }
}
