package baseball.view;

import baseball.model.Game;

public class Result {

    private final Game game;

    public Result(Game game) {
        this.game = game;
    }

    public String getResult() {
        return game.play();
    }
}
