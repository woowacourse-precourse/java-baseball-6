package baseball;

import baseball.core.GameLogic;
import baseball.core.InitRandomNum;
import baseball.core.validator.ValueValidator;
import baseball.game.GameRunner;
import baseball.game.io.Input;
import baseball.game.io.Output;
import baseball.utils.NumberParser;

public class Application {
    public static void main(String[] args) {
        ValueValidator validator = new ValueValidator();
        InitRandomNum initRandomNum = new InitRandomNum();
        GameLogic gameLogic = new GameLogic();
        Input input = new Input();
        Output output = new Output();
        NumberParser numberParser = new NumberParser();
        // 원래는 빌더 어노테이션을 통해 순서로 인한 에러를 방지해야 하나 규칙상 사용이 불가능 하기에 이렇게 작성
        GameRunner gameRunner = new GameRunner(validator,initRandomNum,gameLogic,input,output, numberParser);
        gameRunner.run();
    }
}
