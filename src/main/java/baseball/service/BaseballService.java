package baseball.service;

import baseball.domain.Result;

import java.util.List;

public class BaseballService {
    public String compareInputAnswerToRandomNumbers(List<Integer> inputAnswer, List<Integer> randomNumbers) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < inputAnswer.size(); i++) {
            if (inputAnswer.get(i).equals(randomNumbers.get(i))) {
                strike++;
            } else if (randomNumbers.contains(inputAnswer.get(i))) {
                ball++;
            }
        }

        Result result = new Result(ball, strike);

        return result.getOutputMessage();
    }
}
