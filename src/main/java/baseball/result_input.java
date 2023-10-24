package baseball;

import java.util.List;

public class result_input {
    Compare compare = new Compare();

    public String result_user(List<Integer> comuter, List<Integer> user) {
        int total = compare.num_equal(comuter, user);
        int strike = compare.num_strike(comuter, user);
        int ball = total - strike;

        if (total == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼" + strike + "스트라이크";
    }
}
