package baseball.game;

import baseball.Constant;
import baseball.gameutil.converter.GameInputConverter;
import baseball.gameutil.validate.InputMod;
import baseball.gameutil.numbergenerator.NumberGenerator;
import baseball.gameutil.strgenerator.ResultStringGenerator;
import baseball.gameutil.Score;
import baseball.gameutil.calculator.ScoreCalculator;
import baseball.io.Output;
import baseball.message.MessageString;
import java.util.List;

/**
 * 숫자 야구 게임을 구현한 클래스다.
 */
public class BaseballGame implements Game {

    private final GameInputConverter gameInputConverter;
    private final ResultStringGenerator resultStringGenerator;
    private final ScoreCalculator scoreCalculator;
    private final NumberGenerator numberGenerator;
    private final Output output;

    /**
     * @param gameInputConverter  사용자의 입력을 받게 되는 객체입니다
     * @param resultStringGenerator 결과를 출력하게 되는 객체입니다
     * @param scoreCalculator 점수를 계산하는 객체입니다
     * @param numberGenerator 랜덤 숫자를 생성하는 객체입니다
     * @param output 출력을 담당하는 객체입니다
     */
    public BaseballGame(
        GameInputConverter gameInputConverter,
        ResultStringGenerator resultStringGenerator,
        ScoreCalculator scoreCalculator,
        NumberGenerator numberGenerator,
        Output output
    ) {
        this.gameInputConverter = gameInputConverter;
        this.resultStringGenerator = resultStringGenerator;
        this.scoreCalculator = scoreCalculator;
        this.numberGenerator = numberGenerator;
        this.output = output;
    }

    /**
     * END를 선택할 때까지 게임을 반복합니다.
     */
    @Override
    public void run() {
        output.print(MessageString.INIT_MSG);
        output.print(MessageString.NEW_LINE);
        List<Integer> convertedUserInput;

        do {
            runOneGame();
            output.print(MessageString.RESTART_MSG);
            output.print(MessageString.NEW_LINE);
            convertedUserInput = gameInputConverter.convertBaseballInput(InputMod.RERUN);
        } while (convertedUserInput.get(0) != Constant.RESTART_END);

    }

    private void runOneGame() {
        List<Integer> computerInput = initNumber();
//        output.print(computerInput.toString());
//        output.print(MessageString.NEW_LINE);

        Score score;
        do {
            output.print(MessageString.PROMT_MSG);
            List<Integer> convertedUserInput = gameInputConverter.convertBaseballInput(
                InputMod.GAME);

            score = scoreCalculator.calScore(convertedUserInput, computerInput);
            output.print(resultStringGenerator.result(score));
            output.print(MessageString.NEW_LINE);
        } while (score.getStrike() != Constant.NUMBER_LENGTH);
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
