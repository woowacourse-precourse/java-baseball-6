package baseball;

import baseball.model.Score;

import java.util.List;

public class ScoreCalculator {
    // 랜덤 숫자와 입력한 숫자를 비교하여 결과 반환
    public Score evaluate(List<Integer> randomNumbers, List<Integer> inputNumbers) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (randomNumbers.get(i) == inputNumbers.get(j) && i == j) {
                    strike++;
                }
                if (randomNumbers.get(i) == inputNumbers.get(j) && i != j) {
                    ball++;
                }
            }
        }

        return new Score(ball, strike);
    }
}
