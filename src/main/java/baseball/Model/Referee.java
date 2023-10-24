package baseball.Model;

import java.util.HashMap;
import java.util.Map;

public class Referee {

    public static final String STRIKE = "strike";
    public static final String BALL = "ball";
    int strike;
    int ball;

    public Map<String,Integer> judge(Balls userBalls, Balls computerBalls) {
        calculateStrikeAndBall(userBalls, computerBalls);
        return makeJudgement();
    }

    private void calculateStrikeAndBall(Balls userBalls, Balls computerBalls) {
        int ballAndStrike = countBallsAndStrikes(userBalls, computerBalls);
        int strike = countStrikes(userBalls, computerBalls);

        this.strike = strike;
        this.ball = ballAndStrike - strike;
    }

    private int countBallsAndStrikes(Balls userBalls, Balls computerBalls) {
        return userBalls.countSameNumber(computerBalls);
    }

    private int countStrikes(Balls userBalls, Balls computerBalls) {
        return userBalls.countSameIndexAndNumber(computerBalls);
    }

    private Map<String,Integer> makeJudgement() {
        Map<String,Integer> judgement = new HashMap<String,Integer>();
        judgement.put(STRIKE,strike);
        judgement.put(BALL,ball);
        return judgement;
    }
}
