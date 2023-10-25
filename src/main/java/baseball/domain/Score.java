package baseball.domain;

import java.util.List;

public class Score {
    private int strike;
    private int ball;

    public int countStrike(List<Integer> computerNumber, List<Integer> playerNumber) {
        strike = 0;
        for (int i = 0; i < playerNumber.size(); i++) {
            if (computerNumber.get(i).equals(playerNumber.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> computerNumber, List<Integer> playerNumber) {
        ball = 0;
        for (int i = 0; i < playerNumber.size(); i++) {
            if (computerNumber.contains(playerNumber.get(i)) && !computerNumber.get(i).equals(playerNumber.get(i))) {
                ball += 1;
            }
        }
        return ball;
    }

}
