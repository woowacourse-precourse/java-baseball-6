package baseball;

import java.util.List;
import java.util.Set;

public class Judge {
    static final String NOTHING = "낫싱";
    static final String BALL = "볼";
    static final String STRIKE = "스트라이크";
    Compare compare = new Compare();
    public String judgement(List<Integer> computer, List<Integer> player){
        int total = compare.howMany(computer, player);
        int strike = compare.countStrike(computer, player);
        int ball = total - strike;

        if(total == 0){
            return NOTHING;
        } else if(strike == 0){
            return ball + BALL;
        } else if(ball == 0){
            return strike + STRIKE;
        }
        return ball + BALL + strike + STRIKE;
    }
}
