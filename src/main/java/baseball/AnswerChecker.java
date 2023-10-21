package baseball;

import java.util.List;

public class AnswerChecker {
    public Result checkGuess(List<Integer> answer, List<Integer> input) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answer.size(); i++) {
            if (input.get(i) == answer.get(i)) {
                strike++;
            } else if (answer.contains(input.get(i))) {
                ball++;
            }
        }

        return new Result(strike, ball);
    }
}
