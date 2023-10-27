package baseball;

import java.util.List;

public class Judgement {
    Compare compare = new Compare();
    public String 심판 (List<Integer> 컴퓨터, List<Integer> 플레이어){
        int total = compare.ballCount(컴퓨터, 플레이어);
        int strike = compare.strikeCount(컴퓨터, 플레이어);
        int ball = total - strike;

        if(total == 0){
            return "낫싱";
        }else if(strike == 0){
            return ball + "볼";
        }else if(ball == 0){
            return strike + "스트라이크";
        }
        return ball+" 볼 "+strike+ " 스트라이크";
    }
}
