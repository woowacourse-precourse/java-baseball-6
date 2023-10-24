package baseball;

import baseball.data.GameResult;

import java.util.List;

public class GameCalculator {

    public GameResult calculateResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strike = calculateStrike(computerNumbers, userNumbers);
        int ball = calculateBall(computerNumbers, userNumbers);
        return new GameResult(strike, ball);
    }

    private int calculateStrike(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strike = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int calculateBall(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int ball = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                continue;
            }
            if (computerNumbers.contains(userNumbers.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}
