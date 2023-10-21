package baseball;

import java.util.List;

public class CheckStrike{
    Compare compare = new Compare();
    public String CheckStrikeCount(List<Integer> computer, List<Integer> player){
        int equal = compare.CountEqualNumber(computer, player);
        int strike = compare.CountStrikeNumber(computer, player);
        int ball = equal - strike;

        if(equal == 0){
            return "낫싱";
        }
        else if(ball == 0){
            return strike + "스트라이크";
        }
        else if(strike == 0){
            return ball + "볼";
        }

        return ball + "볼 " + strike + "스트라이크";
    }
}
