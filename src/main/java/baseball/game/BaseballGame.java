package baseball.game;

import baseball.gameutil.Constant;
import baseball.gameutil.GameInputConverter;
import baseball.gameutil.NumberGenerator;
import baseball.gameutil.ResultStringGenerator;
import baseball.gameutil.Score;
import baseball.gameutil.ScoreCalculator;
import baseball.gameutil.ValidateInput;
import baseball.io.Input;
import baseball.io.Output;
import baseball.message.MessageString;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class BaseballGame implements Game {

    private final GameInputConverter gameInputConverter;
    private final ResultStringGenerator resultStringGenerator;
    private final ScoreCalculator scoreCalculator;
    private final ValidateInput validateInput;
    private final NumberGenerator numberGenerator;
    private final Input input;
    private final Output output;

    public BaseballGame(
        GameInputConverter gameInputConverter,
        ResultStringGenerator resultStringGenerator,
        ScoreCalculator scoreCalculator,
        ValidateInput validateInput,
        NumberGenerator numberGenerator,
        Input input,
        Output output
    ) {
        this.gameInputConverter = gameInputConverter;
        this.resultStringGenerator = resultStringGenerator;
        this.scoreCalculator = scoreCalculator;
        this.validateInput = validateInput;
        this.numberGenerator = numberGenerator;
        this.input = input;
        this.output = output;
    }


    @Override
    public void run() {
        output.print(MessageString.INIT_MSG);
        output.print(MessageString.NEW_LINE);

        while (true) {
            runOneGame();
            output.print(MessageString.RESTART_MSG);
            output.print(MessageString.NEW_LINE);
            String rerunInput = validateInput.validateRerunInput(input.getInput());

            if (Integer.parseInt(rerunInput) == Constant.RESTART_END) {
                break;
            }
        }
    }

    private void runOneGame() {
        List<Integer> computerInput = initNumber();
        // output.print(computerInput.toString());
        // output.print(MessageString.NEW_LINE);

        while (true) {
            output.print(MessageString.PROMT_MSG);
            String userInputString = validateInput.validateGameInput(input.getInput());
            List<Integer> userInput = gameInputConverter.convertBaseballStringToList(
                userInputString
            );
            Score score = scoreCalculator.calScore(userInput, computerInput);
            output.print(resultStringGenerator.result(score));
            output.print(MessageString.NEW_LINE);

            if (score.getStrike() == Constant.NUMBER_LENGTH) {
                break;
            }

        }
        output.print(MessageString.END_MSG);
        output.print(MessageString.NEW_LINE);
    }

    private List<Integer> initNumber() {
        return numberGenerator.generate(
            Constant.NUMBER_MIN,
            Constant.NUMBER_MAX,
            Constant.NUMBER_LENGTH
        );
    }
}
