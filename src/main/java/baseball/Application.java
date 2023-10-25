package baseball;

import baseball.game.BaseballGameValueGenerator;
import baseball.game.Converter;
import baseball.game.Game;
import baseball.game.ResultHandler;
import io.GameUserInterface;

public class Application {
    public static void main(String[] args) {
        BaseballGameValueGenerator baseballGameValueGenerator = new BaseballGameValueGenerator();
        Converter converter = new Converter();
        GameUserInterface userInterface = new GameUserInterface(converter);
        ResultHandler resultHandler = new ResultHandler(userInterface, baseballGameValueGenerator);
        Game game = new Game(userInterface, baseballGameValueGenerator, converter, resultHandler);
        game.run();
    }
}
