package baseball;

import java.util.List;

public class Hint {

    private static final int NUMBER_SIZE = 3;
    private int strike = 0;
    private int ball = 0;

    public Hint(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        countStrikeAndBall(computerNumbers, playerNumbers);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private void countStrikeAndBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (playerNumbers.get(i).equals(computerNumbers.get(i))) {
                strike++;
                continue;
            }

           if (computerNumbers.contains(playerNumbers.get(i))) {
               ball++;
           }
        }
    }
}
