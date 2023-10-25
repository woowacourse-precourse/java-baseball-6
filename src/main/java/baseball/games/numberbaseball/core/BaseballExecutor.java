package baseball.games.numberbaseball.core;

import baseball.GamingConsole;

public class BaseballExecutor implements GamingConsole {
    @Override
    public void createNewGame() {
        Baseball baseball = new Baseball();
        baseball.playGame();
    }

}
