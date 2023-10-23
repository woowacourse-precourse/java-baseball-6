package baseball;

import baseball.game.BaseballGameValueGenerator;
import baseball.game.Game;
import io.SoutBaesdPrompt;

public class Application {
    public static void main(String[] args) {
        SoutBaesdPrompt prompt = new SoutBaesdPrompt();
        BaseballGameValueGenerator baseballGameValueGenerator = new BaseballGameValueGenerator();
        Game game = new Game(prompt, baseballGameValueGenerator);
        game.run();
    }
}
