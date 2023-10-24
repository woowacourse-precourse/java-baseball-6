package baseball.game;

import baseball.core.GameLogic;
import baseball.core.InitRandomNum;
import baseball.core.validator.ValueValidator;
import baseball.game.io.Input;
import baseball.game.io.Output;
import baseball.utils.NumberParser;

public class GameRunner {
    private final ValueValidator validator;
    private final InitRandomNum initRandomNum;
    private final GameLogic gameLogic;
    private final Input input;
    private final Output output;
    private final NumberParser numberParser;

    public GameRunner(final ValueValidator validator, final InitRandomNum initRandomNum, final GameLogic gameLogic, final Input input, final Output output, final NumberParser numberParser) {
        this.validator = validator;
        this.initRandomNum = initRandomNum;
        this.gameLogic = gameLogic;
        this.input = input;
        this.output = output;
        this.numberParser = numberParser;
    }

    public void run(){
        output.start();
        Game game = new Game(input,output, numberParser);
        game.gameSet(validator,gameLogic,initRandomNum);
        // 일단 한판 하고 reset하고 recheck 통해 다시 수행..
        do {
            game.play();
        } while (game.recheck());
    }
}
