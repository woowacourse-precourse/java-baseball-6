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

        int strike = getStrike(inputNumbers);
        int ball = getBall(inputNumbers) - strike;

        return new BaseballResult(strike, ball, false);
    }


    private int getStrike(List<Integer> inputNumbers) {
        int strike = 0;
        for (int i = 0; i < answer.size(); ++i) {
            if (isStrike(answer.get(i), inputNumbers.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private boolean isStrike(Integer answer, Integer input) {
        return answer.equals(input);
    }


    private int getBall(List<Integer> inputNumbers) {
        int ball = 0;
        for (int i = 0; i < answer.size(); ++i) {
            if (isBall(inputNumbers.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private boolean isBall(Integer givenNumber) {
        for (Integer answerNum : answer) {
            if (answerNum.equals(givenNumber)) {
                return true;
            }
        }
        return false;
    }


}
