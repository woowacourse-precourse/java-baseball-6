package baseball;

import baseball.context.BaseballContext;
import baseball.game.BaseballGame;
import baseball.game.GameLoop;

import baseball.io.input.DefaultInput;
import baseball.io.input.Input;

public class Application {
    public static void main(String[] args) {
        Input input = new DefaultInput();
        BaseballContext baseballContext = new BaseballContext();
        BaseballGame game = new BaseballGame();
        GameLoop gameLoop = new GameLoop(input, baseballContext, game);

        gameLoop.run();
    }
}
