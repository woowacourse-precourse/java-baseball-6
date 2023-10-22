package baseball;

import java.util.List;

public class GameResult {
    public String score(List<Integer> computer, List<Integer> userNumber) {
        Compare compare = new Compare();

        int total = compare.countTotal(computer, userNumber);
        int strike = compare.countStrike(computer, userNumber);

        int ball = total - strike;

        if (total == 0) {
            return "낫싱" ;
        }
        else if (strike == 0) {
            return  ball+"볼";
        } else if (ball == 0) {
            return strike+"스트라이크";
        }
        return ball+"볼 "+strike+"스트라이크";
    }

}
