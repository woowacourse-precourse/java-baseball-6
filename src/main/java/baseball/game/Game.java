package baseball.game;

import baseball.player.Computer;
import baseball.player.User;

public interface Game {

    void startGame(Computer computer, User user);
    boolean playTurn();
    boolean isRestart();
}
