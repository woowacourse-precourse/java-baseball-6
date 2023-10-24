package baseball.model;

import java.util.List;

public class BaseballGameUtils {
    public BaseballGameUtils() {}

    public Score checkScore(List<Integer> computerNumber, List<Integer> userNumber) {
        int ball = 0;
        int strike = 0;

        ball = checkBall(computerNumber, userNumber);
        strike = checkStrike(computerNumber, userNumber);

        return new Score(ball, strike);
    }

    private int checkBall(List<Integer> computerNumber, List<Integer> userNumber) {
        int count = 0;

        for (int i = 0; i < computerNumber.size(); i++) {
            count = incrementBallCount(computerNumber, userNumber, count, i);
        }

        return count;
    }

    private int incrementBallCount(List<Integer> computerNumber, List<Integer> userNumber, int count, int i) {
        if (computerNumber.contains(userNumber.get(i)) && computerNumber.indexOf(userNumber.get(i)) != i)
            count++;

        return count;
    }

    private int checkStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        int count = 0;

        for (int i = 0; i < computerNumber.size(); i++) {
            count = incrementStrikeCount(computerNumber, userNumber, count, i);
        }

        return count;
    }

    private int incrementStrikeCount(List<Integer> computerNumber, List<Integer> userNumber, int count, int i) {
        if (computerNumber.get(i) == userNumber.get(i)) {
            count++;
        }

        return count;
    }

}
