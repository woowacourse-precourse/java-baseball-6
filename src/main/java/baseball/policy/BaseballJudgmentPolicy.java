package baseball.policy;

import baseball.utility.BaseballJudgment;
import baseball.utility.BaseballScore;

import java.util.List;

public class BaseballJudgmentPolicy {

    public BaseballScore compareNumbers(List<Integer> computerNumbers, List<Integer> userNumbers) {

        BaseballScore baseballScore = new BaseballScore();

        for (int i = 0; i < userNumbers.size(); i++) {
            Integer userNumber = userNumbers.get(i);
            BaseballJudgment baseballJudgment = makeJudgment(computerNumbers, userNumber, i);
            switch (baseballJudgment) {
                case strike -> baseballScore.plusStrike();
                case ball -> baseballScore.plusBall();
            }
        }

        return baseballScore;
    }

    private BaseballJudgment makeJudgment(List<Integer> computerNumbers, Integer userNumber, int userNumberIndex) {
        BaseballJudgment baseballJudgment;
        if (computerNumbers.get(userNumberIndex) == userNumber) {
            baseballJudgment = BaseballJudgment.strike;
        } else if (computerNumbers.contains(userNumber)) {
            baseballJudgment = BaseballJudgment.ball;
        } else {
            baseballJudgment = BaseballJudgment.nothing;
        }
        return baseballJudgment;
    }
}
