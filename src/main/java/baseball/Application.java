package baseball;

import baseball.context.BaseballContext;
import baseball.game.BaseballGame;
import baseball.game.GameLoop;
import baseball.input.Input;
import baseball.validation.InputValidator;

public class Application {
    public static void main(String[] args) {
        Input input = new Input("숫자를 입력해주세요 : ", new InputValidator());
        BaseballContext baseballContext = new BaseballContext();
        BaseballGame game = new BaseballGame();
        GameLoop gameLoop = new GameLoop(input, baseballContext, game);

        gameLoop.run();
    }
}
