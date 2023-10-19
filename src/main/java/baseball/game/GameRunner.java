package baseball.game;

import baseball.config.GameLogic;
import baseball.config.InitRandomNum;
import baseball.config.validator.ValueValidator;
import baseball.utils.Input;
import baseball.utils.Output;
import baseball.utils.Utils;

public class GameRunner {
    private final ValueValidator validator = new ValueValidator();
    private final InitRandomNum initRandomNum = new InitRandomNum();
    private final GameLogic gameLogic = new GameLogic();
    private final Input input;
    private final Output output;
    private final Utils utils;

    public GameRunner() {
        this.input = new Input();
        this.output = new Output();
        this.utils = new Utils();
    }

    public void run(){
        output.start();
        Game game = new Game(input,output,utils);
        game.gameSet(validator,gameLogic,initRandomNum);
        // 일단 한판 하고 reset하고 recheck 통해 다시 수행
        do {
            game.play();
            game.reset();
        } while (game.recheck());
    }
}
