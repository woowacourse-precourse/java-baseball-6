package baseball.policy;

import baseball.utility.Judgment;
import baseball.utility.BaseballScore;

import java.util.List;

public class BaseballJudgmentPolicy {

    public BaseballScore compareNumbers(List<Integer> computerNumbers, List<Integer> userNumbers) {

        BaseballScore baseballScore = new BaseballScore();

        for (int i = 0; i < userNumbers.size(); i++) {
            Integer userNumber = userNumbers.get(i);
            Judgment judgment = makeJudgment(computerNumbers, userNumber, i);
            switch (judgment) {
                case strike -> baseballScore.plusStrike();
                case ball -> baseballScore.plusBall();
            }
        }

        return baseballScore;
    }

    private Judgment makeJudgment(List<Integer> computerNumbers, Integer userNumber, int userNumberIndex) {
        Judgment judgment;
        if (computerNumbers.get(userNumberIndex) == userNumber) {
            judgment = Judgment.strike;
        } else if (computerNumbers.contains(userNumber)) {
            judgment = Judgment.ball;
        } else {
            judgment = Judgment.nothing;
        }
        return judgment;
    }
}
