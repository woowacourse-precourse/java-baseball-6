package baseball.logic;

import baseball.validator.BaseballRuleChecker;

import java.util.List;

public class BaseballLogic {

    private List<Integer> answer;
    private BaseballRuleChecker resultValidator;

    public BaseballLogic(List<Integer> answer) {
        this.answer = answer;
        this.resultValidator = new BaseballRuleChecker(answer);
    }

    public int[] checkNumbers(List<Integer> userInput) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < answer.size(); i++) {
            if (resultValidator.isStrike(i, userInput.get(i))) {
                strikeCount++;
            }
            if (resultValidator.isBall(userInput.get(i))) {
                ballCount ++;
            }
        }

        return new int[]{strikeCount, ballCount};
    }
}
