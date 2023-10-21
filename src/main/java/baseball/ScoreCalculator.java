package baseball;

import java.util.List;

public class ScoreCalculator {

    int ball;
    int strike;

    public void doCalculate(List<Integer> randomNumbers, List<Integer> guessNumbers) {

        computeStrike(randomNumbers, guessNumbers);
        System.out.println("strike = " + strike);

        computeBall(randomNumbers, guessNumbers);
        System.out.println("ball = " + ball);

    }

    private void computeBall(List<Integer> randomNumbers, List<Integer> guessNumbers) {

        for (Integer i : guessNumbers) {

            if (randomNumbers.contains(i)) {
                ball++;
            }

        }

        ball -= strike;
    }

    private void computeStrike(List<Integer> randomNumbers, List<Integer> guessNumbers) {

        for (int i = 0; i < 3; i++) {

            if (randomNumbers.get(i) == guessNumbers.get(i)) {
                strike++;
            }

        }
    }

}
