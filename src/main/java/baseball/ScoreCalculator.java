package baseball;

import java.util.List;

public class ScoreCalculator {
    public static Score calculate(List<Integer> pitchInput, List<Integer> numbers) {
        Integer ball = 0;
        Integer strike = 0;

        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index).equals(pitchInput.get(index))) {
                strike++;
            }

            for (int index2 = 1; index2 < 3; index2++) {
                if (numbers.get((index + index2) % 3).equals(pitchInput.get(index))) {
                    ball++;
                }
            }
        }

        return Score.of(strike, ball);
    }
}
