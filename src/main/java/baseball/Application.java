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
import baseball.gameutil.ValidateInput;
import baseball.gameutil.ValidateInputBaseball;
import baseball.io.ConsoleInput;
import baseball.io.ConsoleOutput;
import baseball.io.Input;
import baseball.io.Output;

public class Application {

    public static void main(String[] args) {
        GameInputConverter gameInputConverter = new GameInputConverterBaseball();
        ResultStringGenerator resultStringGenerator = new ResultStringGeneratorBaseBall();
        ScoreCalculator scoreCalculator = new ScoreCalculatorBaseBall();
        ValidateInput validateInput = new ValidateInputBaseball();
        NumberGenerator numberGenerator = new NumberGeneratorBaseball();
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();

        Game game = new BaseballGame(
            gameInputConverter,
            resultStringGenerator,
            scoreCalculator,
            validateInput,
            numberGenerator,
            input,
            output
        );
        game.run();
    }
}
