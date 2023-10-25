package baseball;

import java.util.List;

public class Game {
    public String playGame(List<Integer> computer, List<Integer> player){
        Compare compare = new Compare();

        int same = compare.sameNumber(computer, player);
        int strike = compare.checkStrike(computer, player);
        int ball = same - strike;

        if(same == 0){
            return "낫싱";
        }else if(strike == 0){
            return ball + "볼";
        }else if(ball == 0){
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";

    }
}
