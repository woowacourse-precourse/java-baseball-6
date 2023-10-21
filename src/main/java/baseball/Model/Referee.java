package baseball.Model;

import java.util.HashMap;
import java.util.Map;

public class Referee {

    public static final String STRIKE = "strike";
    public static final String BALL = "ball";
    int strike;
    int ball;

    public void judge(User user, Computer computer) {
        int sameNumberCount = countSameNumber(user, computer);
        int sameIndexAndNumberCount = countStrike(user, computer);

        strike = sameIndexAndNumberCount;
        ball = sameNumberCount - strike;
    }

    private int countSameNumber(User user, Computer computer) {
        return user.compareAndCount(computer);
    }

    private int countStrike(User user, Computer computer) {
        return user.countSameIndexAndNumber(computer);
    }

    public Map<String,Integer> getJudgement() {
        Map<String,Integer> judgement = new HashMap<String,Integer>();
        judgement.put(STRIKE,strike);
        judgement.put(BALL,ball);
        return judgement;
    }
}
