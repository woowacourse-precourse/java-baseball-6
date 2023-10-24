package baseball;

import java.util.List;

public class Score {
    Compare compare = new Compare();
    public String score(List<Integer> computer, List<Integer> player){
        int total = compare.countAll(computer, player);
        int strike = compare.countStrike(computer, player);
        int ball = compare.countBall(computer, player);

        if(total == 0){
            return "낫싱";
        }else if(strike == 0){
            return ball + "볼";
        }else if(ball == 0){
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
