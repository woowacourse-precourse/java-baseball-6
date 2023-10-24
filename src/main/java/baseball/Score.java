package baseball;

import java.util.List;

/**
 * The 'Score' class represent the score of a baseball game between a computer and a player.
 * It calculates the number of strikes and balls for a given combination of computer and player guesses.
 */
public class Score {
    private int ball;
    private int strike;
    List<Integer> computer;
    List<Integer> player;

    public Score(List<Integer> computer, List<Integer> player) {
        this.strike = 0;
        this.ball = 0;
        this.computer = computer;
        this.player = player;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isNothing() {
        if (strike > 0 || ball > 0) {
            return false;
        }
        return true;
    }

    public boolean isStrike() {
        if (strike == Numbers.getMaxLength()) {
            return true;
        }
        return false;
    }

    /**
     * Count the score of strike and ball between computer and player.
     * @throws IllegalArgumentException if the counting target does not exist.
     */
    public void calculate() {
        if (computer == null || player == null) {
            throw new IllegalArgumentException();
        }

        int length = Numbers.getMaxLength();
        for (int i = 0; i < length; i++) {
            /* count the strike */
            if (computer.get(i) == player.get(i)) {
                strike = strike + 1;
            }
            /* count the ball */
            for (int j = 0; j < length; j++) {
                if (i != j && computer.get(i) == player.get(j)) {
                    ball = ball + 1;
                }
            }

        }

    }
}
