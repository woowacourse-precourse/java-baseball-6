package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Game;
import baseball.domain.GameState;

public class Service {
    private final Game game;

    public Service(Game game) {
        this.game = game;
    }

    public void startGame() {
        game.start();
    }

    public void endGame() {
        game.end();
    }

    public void restartGame() {
        game.restart();
    }

    public String hint(Balls input) {
        return game.hint(input);
    }

    public GameState getGameState() {
        return game.getGameState();
    }
}
