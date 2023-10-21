package baseball;

import java.util.List;

public class Hint {

    private int strike = 0;
    private int ball = 0;

    private Hint(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        countStrikeAndBall(computerNumbers, playerNumbers);
    }

    public static Hint of(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        return new Hint(computerNumbers, playerNumbers);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private void countStrikeAndBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < Constants.NUMBERS_SIZE; i++) {
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
