package baseball.Model;

import java.util.HashMap;
import java.util.Map;

public class Referee {

    public static final String STRIKE = "strike";
    public static final String BALL = "ball";
    int strike;
    int ball;

    public void judge(Numbers userNumbers, Numbers computerNumbers) {
        int ballAndStrike = countBallAndStrike(userNumbers, computerNumbers);
        int strike = countStrike(userNumbers, computerNumbers);

        this.strike = strike;
        this.ball = ballAndStrike - strike;
    }

    private int countBallAndStrike(Numbers userNumbers, Numbers computerNumbers) {
        return userNumbers.countSameNumber(computerNumbers);
    }

    private int countStrike(Numbers userNumbers, Numbers computerNumbers) {
        return userNumbers.countSameIndexAndNumber(computerNumbers);
    }

    public Map<String,Integer> getJudgement() {
        Map<String,Integer> judgement = new HashMap<String,Integer>();
        judgement.put(STRIKE,strike);
        judgement.put(BALL,ball);
        return judgement;
    }
}
