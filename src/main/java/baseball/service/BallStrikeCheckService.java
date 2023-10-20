package baseball.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class BallStrikeCheckService {


    public Map<String, Integer> resultBallStrike(int[] userNumber, List<Integer> comNumber) {
        Map<String, Integer> result = new HashMap<>();
        int ball = countBall(userNumber, comNumber);
        int strike = countStrike(userNumber, comNumber);
        result.put("BALL", ball);
        result.put("STRIKE", strike);
        return result;
    }


    private int countBall(int[] userNumber, List<Integer> comNumber) {
        return (int) Stream.iterate(0, i -> i + 1).limit(3)
                .filter(i -> userNumber[i] != comNumber.get(i) && comNumber.contains(userNumber[i]))
                .count();
    }

    private int countStrike(int[] userNumber, List<Integer> comNumber) {
        return (int) Stream.iterate(0, i -> i + 1).limit(3)
                .filter(i -> userNumber[i] == comNumber.get(i))
                .count();
    }
}
