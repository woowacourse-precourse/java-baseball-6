package baseball;

import baseball.game.Game;
import baseball.util.Input;
import baseball.util.InputValidator;
import baseball.util.Output;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        Input input = new Input(inputValidator);
        Output output = new Output();

        Game game = new Game(input, output);
        game.run();
    }
}
