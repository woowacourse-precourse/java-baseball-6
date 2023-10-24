package baseball.model;

import java.util.List;

public class JudgementResult {
    CompareNumber compareNumber = new CompareNumber();

    public String judgementResult(List<Integer> computer, List<Integer> player) {
        int total = compareNumber.countSameNumber(computer, player);
        int strike = compareNumber.countStrike(computer, player);
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
