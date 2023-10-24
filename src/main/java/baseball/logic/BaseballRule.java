package baseball.logic;

import baseball.io.Validator;
import java.util.List;

public class BaseballRule {

    private final List<Integer> answer;


    public BaseballRule(List<Integer> answer) {
        Validator.validateNotEmpty(answer);
        this.answer = answer;
    }

    public BaseballResult checkBaseball(List<Integer> inputNumbers) {
        Validator.validateNotEmpty(inputNumbers);

        if (answer.equals(inputNumbers)) {
            return BaseballResult.allStrike(answer.size());
        }

        int strike = countStrikes(inputNumbers);
        int ball = countBalls(inputNumbers);

        return BaseballResult.strikeAndBall(strike, ball);
    }


    private int countStrikes(List<Integer> inputNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < answer.size(); ++i) {
            if (isStrike(inputNumbers.get(i), answer.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private boolean isStrike(Integer targetNumber, Integer answer) {
        return answer.equals(targetNumber);
    }


    private int countBalls(List<Integer> inputNumbers) {
        int ballCount = 0;

        for (int i = 0; i < inputNumbers.size(); ++i) {
            if (isBall(inputNumbers.get(i), i)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    private boolean isBall(Integer targetNumber, Integer excludeIndex) {
        for (int i = 0; i < answer.size(); ++i) {
            if (i != excludeIndex && answer.get(i).equals(targetNumber)) {
                return true;
            }
        }
        return false;
    }

}
