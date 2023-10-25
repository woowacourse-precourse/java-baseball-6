package baseball.game;

import baseball.player.Players;
import baseball.result.Result;

public class Inning {
    private Players players;
    private Result result;

    public Inning() {
        this.players = new Players();
    }

    public void startInning() {
        players.createComputerNumber();

        do {
            players.createUserNumber();

            result = players.compareNumbers();

            result.checkResult();
        } while (!result.isWin());

        result.printWin();
    }
}
