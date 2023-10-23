package baseball.validator;

import java.util.List;

public class BaseballRuleChecker {
    private List<Integer> answer;

    public BaseballRuleChecker(List<Integer> answer) {
        this.answer = answer;
    }

    public boolean isStrike(int position, int number) {
        return answer.get(position) == number;
    }

    public boolean isBall(int number) {
        return answer.contains(number) && !isStrike(answer.indexOf(number), number);
    }

    public boolean isGameOver(List<Integer> userInput) {
        for (int i = 0; i < answer.size(); i++) {
            if (!isStrike(i, userInput.get(i))) {
                return false;
            }
        }
        return true;
    }
}
