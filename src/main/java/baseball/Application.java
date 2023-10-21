package baseball;

import baseball.game.service.Answer;
import baseball.game.service.BaseballGame;
import baseball.game.core.GameLoop;

import baseball.game.core.GameLoopBuilder;
import baseball.io.input.DefaultInput;
import baseball.io.input.Input;

public class Application {
    public static void main(String[] args) {
        Input input = new DefaultInput();
        BaseballGame game = new BaseballGame();
        Answer answer = new Answer();
        GameLoop gameLoop = new GameLoopBuilder()
            .input(input)
            .gameService(game)
            .computer(answer)
            .build();

        gameLoop.run();
    }
}
