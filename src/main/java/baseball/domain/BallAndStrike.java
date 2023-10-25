package baseball.domain;

import java.util.List;
import java.util.Map;

public class BallAndStrike {
    private int balls;
    private int strikes;

    public BallAndStrike(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    public static BallAndStrike calcBallsAndStrikes(BaseBallNumber inputNumber, BaseBallNumber targetNumber) {
        Map<Integer, Integer> inputCounterMap = inputNumber.getBaseballNumberCounterMap();
        Map<Integer, Integer> targetCounterMap = targetNumber.getBaseballNumberCounterMap();

        List<Integer> inputBaseballNumber = inputNumber.getBaseballNumber();
        List<Integer> targetBaseballNumber = targetNumber.getBaseballNumber();

        int balls = getNumberCounterUnion(inputCounterMap, targetCounterMap);
        int strikes = getStrikes(inputBaseballNumber, targetBaseballNumber);

        balls -= strikes;

        return new BallAndStrike(balls, strikes);
    }

    private static int getStrikes(List<Integer> inputBaseballNumber, List<Integer> targetBaseballNumber) {
        int strikes = 0;

        for (int i = 0; i < targetBaseballNumber.size(); i++) {
            if (inputBaseballNumber.get(i).equals(targetBaseballNumber.get(i))) {
                strikes++;
            }
        }

        return strikes;
    }

    private static int getNumberCounterUnion(Map<Integer, Integer> inputCounterMap,
                                             Map<Integer, Integer> targetCounterMap) {
        int balls = 0;

        for (Integer key : targetCounterMap.keySet()) {
            if (inputCounterMap.containsKey(key)) {
                balls += Math.min(targetCounterMap.get(key), inputCounterMap.get(key));
            }
        }

        return balls;
    }

    @Override
    public String toString() {
        if (balls == 0 && strikes == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();

        if (balls > 0) {
            result.append(balls).append("볼");
        }

        if (strikes > 0) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(strikes).append("스트라이크");
        }

        return result.toString();
    }

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }
}
