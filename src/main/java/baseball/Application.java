package baseball;

import baseball.context.BaseballContext;
import baseball.game.BaseballGame;
import baseball.game.GameLoop;
import baseball.game.dto.BaseballMatchResults;
import baseball.game.transform.BaseballMatchResultsStringTransformer;

import baseball.io.input.Input;

import baseball.game.transform.Transformer;
import baseball.validation.InputValidator;

public class Application {
    public static void main(String[] args) {
        Transformer<BaseballMatchResults, String> transformer = new BaseballMatchResultsStringTransformer();
        Input input = new Input("숫자를 입력해주세요 : ", new InputValidator());
        BaseballContext baseballContext = new BaseballContext();
        BaseballGame game = new BaseballGame();
        GameLoop gameLoop = new GameLoop(input, baseballContext, game);

        gameLoop.run();
    }
}
