package baseball.domain;

import java.util.List;

public class Referee {
    public BallCount call(List<Integer> answers, List<Integer> pickNumbers) {
        CheckMachine checkMachine = new CheckMachine(new BallCount(0, 0));
        return checkMachine.checkAnswer(answers, pickNumbers);
    }
}
