package baseball.game;

import java.util.List;
import baseball.evaluator.ResultEvaluator;
import baseball.generator.RandomNumberGenerator;
import baseball.matcher.BaseballNumberMatcher;
import baseball.matcher.NumberMatcher;
import baseball.message.Printer;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    static RandomNumberGenerator generator = new RandomNumberGenerator();
    static BaseballNumberMatcher baseballMatcher = new BaseballNumberMatcher();
    static NumberMatcher matcher = new NumberMatcher();
    static ResultEvaluator evaluator = new ResultEvaluator();

    public static boolean play() {
        List<Integer> randomNumbers = generator.createRandomNumber();

        while (true) {
            Printer.input();
            String input = Console.readLine();
            List<Integer> inputNumbers;

            try {
                inputNumbers = matcher.checkInputNumber(input);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("잘못된 입력값입니다.", e);
            }

            Baseball value = baseballMatcher.matchNumbers(inputNumbers, randomNumbers);

            if (evaluator.evaluate(value)) {
                return evaluator.restart();
            }
        }
    }
}
