package baseball.game.core;

import baseball.game.Answer;
import baseball.game.BaseballGame;
import baseball.io.input.Input;

public class GameLoopBuilder {

    private Input input;
    private BaseballGame baseballGame;
    private Answer answer;

    public GameLoopBuilder input(Input input) {
        this.input = input;
        return this;
    }

    public GameLoopBuilder gameService(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
        return this;
    }

    public GameLoopBuilder computer(Answer answer) {
        this.answer = answer;
        return this;
    }

    public GameLoop build() {
        return new GameLoop(input, baseballGame, answer);
    }
}
