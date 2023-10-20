package baseball.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {

    int strike;
    int ball;

    public void judge(Numbers user, Numbers computer) {
        int sameNumberCount = countSameNumber(user, computer);
        int sameIndexAndNumberCount = countStrike(user, computer);

        strike = sameIndexAndNumberCount;
        ball = sameNumberCount - strike;
    }

    private int countSameNumber(Numbers user, Numbers computer) {
        return user.compareAndCount(computer);
    }

    private int countStrike(Numbers user, Numbers computer) {
        return user.countSameIndexAndNumber(computer);
    }

    public Map<String,Integer> getJudgement() {
        Map<String,Integer> judgement = new HashMap<String,Integer>();
        judgement.put("strike",strike);
        judgement.put("ball",ball);
        return judgement;
    }
}
