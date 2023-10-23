package baseball;

import baseball.game.BaseballGame;
import baseball.game.Game;
import baseball.gameutil.GameInputConverter;
import baseball.gameutil.GameInputConverterBaseball;
import baseball.gameutil.NumberGenerator;
import baseball.gameutil.NumberGeneratorBaseball;
import baseball.gameutil.ResultStringGenerator;
import baseball.gameutil.ResultStringGeneratorBaseBall;
import baseball.gameutil.ScoreCalculator;
import baseball.gameutil.ScoreCalculatorBaseBall;
import baseball.io.ConsoleInput;
import baseball.io.ConsoleOutput;
import baseball.io.Input;
import baseball.io.Output;

public class Application {

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        GameInputConverter gameInputConverter = new GameInputConverterBaseball(input);
        ResultStringGenerator resultStringGenerator = new ResultStringGeneratorBaseBall();
        ScoreCalculator scoreCalculator = new ScoreCalculatorBaseBall();
        NumberGenerator numberGenerator = new NumberGeneratorBaseball();

        Game game = new BaseballGame(
            gameInputConverter,
            resultStringGenerator,
            scoreCalculator,
            numberGenerator,
            output
        );
        game.run();
    }
}
