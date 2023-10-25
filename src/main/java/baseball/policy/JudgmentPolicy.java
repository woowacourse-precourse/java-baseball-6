package baseball.policy;

import baseball.utility.Judgment;
import baseball.utility.Score;

import java.util.List;

public class JudgmentPolicy {

    public Score compareNumbers(List<Integer> computerNumbers, List<Integer> userNumbers) {

        Score score = new Score();

        for (int i = 0; i < userNumbers.size(); i++) {
            Integer userNumber = userNumbers.get(i);
            Judgment judgment = makeJudgment(computerNumbers, userNumber, i);
            switch (judgment) {
                case strike -> score.plusStrike();
                case ball -> score.plusBall();
            }
        }

        return score;
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
