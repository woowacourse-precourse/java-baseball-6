package baseball.core;

import java.util.List;

public class Core {

    public int countAll(List<Integer> userNumber, List<Integer> computerNumber) {
        int result = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (computerNumber.contains(userNumber.get(i))) {
                result += 1;
            }
        }
        return result;
    }

    public int countStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        int strike = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike += 1;
            }
        }
        return strike;
    }

    public String jugement(List<Integer> userNumber, List<Integer> computerNumber) {
        int total = countAll(userNumber, computerNumber);
        int strike = countStrike(userNumber, computerNumber);
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
