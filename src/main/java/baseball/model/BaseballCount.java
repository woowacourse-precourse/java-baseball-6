package baseball.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballCount {

    private Map<String, Integer> hitterCount;

    public BaseballCount() {
        hitterCount = new HashMap<>();
        hitterCount.put("ball", 0);
        hitterCount.put("strike", 0);
    }

    public Map<String, Integer> pitch(List<Integer> user, List<Integer> computer) {
        int ballCount = calculateBallCount(user, computer);
        int strikeCount = calculateStrikeCount(user, computer);
        ballCount -= strikeCount;

        hitterCount.put("ball", ballCount);
        hitterCount.put("strike", strikeCount);
        return hitterCount;
    }

    private int calculateStrikeCount(List<Integer> userNumber, List<Integer> computerNumber) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber.get(i).equals(computerNumber.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int calculateBallCount(List<Integer> userNumber, List<Integer> computerNumber) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber.contains(computerNumber.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}
