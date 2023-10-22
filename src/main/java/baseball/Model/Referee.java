package baseball.Model;

import java.util.HashMap;
import java.util.Map;

public class Referee {

    public static final String STRIKE = "strike";
    public static final String BALL = "ball";
    int strike;
    int ball;

    public Map<String,Integer> judge(Numbers userNumbers, Numbers computerNumbers) {
        calculateStrikeAndBall(userNumbers, computerNumbers);
        return makeJudgement();
    }

    private void calculateStrikeAndBall(Numbers userNumbers, Numbers computerNumbers) {
        int ballAndStrike = countBallsAndStrikes(userNumbers, computerNumbers);
        int strike = countStrikes(userNumbers, computerNumbers);

        this.strike = strike;
        this.ball = ballAndStrike - strike;
    }

    private int countBallsAndStrikes(Numbers userNumbers, Numbers computerNumbers) {
        return userNumbers.countSameNumber(computerNumbers);
    }

    private int countStrikes(Numbers userNumbers, Numbers computerNumbers) {
        return userNumbers.countSameIndexAndNumber(computerNumbers);
    }

    private Map<String,Integer> makeJudgement() {
        Map<String,Integer> judgement = new HashMap<String,Integer>();
        judgement.put(STRIKE,strike);
        judgement.put(BALL,ball);
        return judgement;
    }
}
