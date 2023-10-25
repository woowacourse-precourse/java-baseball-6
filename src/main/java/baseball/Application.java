package baseball;

import baseball.console.Prompt;
import baseball.engine.BaseBallGame;
import baseball.engine.manager.Referee;
import baseball.mapper.BaseBallGameMapper;
import baseball.validator.Validator;

public class Application {
    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        Validator validator = new Validator();
        BaseBallGameMapper baseBallGameMapper = new BaseBallGameMapper();
        Referee referee = new Referee();

        BaseBallGame game = new BaseBallGame(prompt, validator, baseBallGameMapper, referee);
        game.start();
    }
}
