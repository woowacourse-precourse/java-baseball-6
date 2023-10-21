package baseball;

import java.util.List;

public class ScoreCalculator {

    int ball;
    int strike;

    public void doCalculate(List<Integer> randomNumbers, List<Integer> guessNumbers) {

        computeStrike(randomNumbers, guessNumbers);
        System.out.println("strike = " + strike);

    }

    private void computeStrike(List<Integer> randomNumbers, List<Integer> guessNumbers) {
        // 이런짓을 해도 되나..?
        for (int i = 0; i < 3; i++) {

            if (randomNumbers.get(i) == guessNumbers.get(i)) {
                strike++;
            }

        }
    }

}
