package baseball;

import java.util.List;

public class Referee {
    CompareNum compareNum = new CompareNum();

    public String Judgement(List<Integer> computerNum, List<Integer> userNum) {
        int total = compareNum.countTotal(computerNum, userNum);
        int strike = compareNum.countStrikes(computerNum, userNum);
        int ball = total - strike;

        if(total == 0) {
            return "낫싱";
        } else if(strike == 0) {
            return ball + "볼";
        } else if(ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
