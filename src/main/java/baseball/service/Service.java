package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Game;

public class Service {
    private final Game game;

    public Service(Game game) {
        this.game = game;
    }

    public void startGame() {
        game.start();
    }

    public String hint(Balls input) {
        return game.hint(input);
    }
}
