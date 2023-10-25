package baseball;

import baseball.game.Game;

public class Machine {
    private static Game game;

    public Machine() {
        this(null);
    }

    public Machine(Game initialGame) {
        game = initialGame;
    }

    public void playGame() {
        validateGameExistence();

        game.play();
    }

    public void validateGameExistence() {
        if (game == null) {
            throw new IllegalArgumentException();
        }
    }
}
