package baseball.game;

import baseball.config.GameLogic;
import baseball.config.InitRandomNum;
import baseball.config.validator.ValueValidator;
import baseball.utils.Input;
import baseball.utils.Output;
import baseball.utils.Utils;

public class GameRunner {
    private final ValueValidator validator;
    private final InitRandomNum initRandomNum;
    private final GameLogic gameLogic;
    private final Input input;
    private final Output output;
    private final Utils utils;

    public GameRunner() {
        this.input = new Input();
        this.output = new Output();
        this.utils = new Utils();
        this.gameLogic = new GameLogic();
        this.initRandomNum = new InitRandomNum();
        this.validator = new ValueValidator();
    }

    public void run(){
        output.start();
        Game game = new Game(input,output,utils);
        game.gameSet(validator,gameLogic,initRandomNum);
        // 일단 한판 하고 reset하고 recheck 통해 다시 수행
        do {
            game.play();
            reset();
        } while (game.recheck());
    }

    // 전체적인 게임을 관리하는 곳이므로 reset도 여기서 하는게 맞다고 판단
    public void reset() {
        initRandomNum.reset();
    }
}
