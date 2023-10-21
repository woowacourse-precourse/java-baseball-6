package baseball;

import java.util.List;

public class ScoreCalculator {

    public int computeStrike(List<Integer> randomNumbers, List<Integer> guessNumbers) {

        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (randomNumbers.get(i) == guessNumbers.get(i)) {
                strike++;
            }
        }

        return strike;
    }

    public int computeBall(List<Integer> randomNumbers, List<Integer> guessNumbers, int strike) {

        int  ball = 0;

        for (Integer i : guessNumbers) {
            if (randomNumbers.contains(i)) {
                ball++;
            }

        }

        ball -= strike;

        return ball;
    }

}
