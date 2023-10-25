package baseball;

import java.util.List;

public class Judge {
    CompareBalls compareBalls = new CompareBalls();

    public String judge(List<Integer> computer, List<Integer> player){
        int total = compareBalls.countTotal(computer, player);
        int strike = compareBalls.countStrike(computer, player);
        int ball = total - strike;

        if (total == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }

        return ball + "볼 " + strike + "스트라이크";
    }
}
