package baseball;

import baseball.game.BaseballGame;
import baseball.game.Game;
import baseball.gameutil.converter.GameInputConverter;
import baseball.gameutil.converter.GameInputConverterBaseball;
import baseball.gameutil.numbergenerator.NumberGenerator;
import baseball.gameutil.numbergenerator.NumberGeneratorBaseball;
import baseball.gameutil.strgenerator.ResultStringGenerator;
import baseball.gameutil.strgenerator.ResultStringGeneratorBaseBall;
import baseball.gameutil.calculator.ScoreCalculator;
import baseball.gameutil.calculator.ScoreCalculatorBaseBall;
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
