package baseball;

import java.util.List;

public class PlayGame {
    ScoreCheck scoreCheck = new ScoreCheck();
    public String gameResult(List<Integer> user, List<Integer>computer){
        int result = scoreCheck.totalScore(user, computer);
        int strike = scoreCheck.strikeCount(user,computer);
        int ball = scoreCheck.ballCount(user, computer);

        if(result ==0){
            return "낫싱";
        } else if(strike == 0){
            return (ball + "볼");
        } else if (ball == 0) {
            return  strike + "스트라이크";

        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
