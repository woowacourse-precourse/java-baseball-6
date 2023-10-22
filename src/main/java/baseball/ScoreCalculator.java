package baseball;

import java.util.List;

public class ScoreCalculator {
    public static List<Integer> calculate(List<Integer> pitchInput, List<Integer> numbers) {
        Integer balls = 0;
        Integer strikes = 0;

        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index).equals(pitchInput.get(index))) {
                strikes++;
            }

            for (int index2 = 1; index2 < 3; index2++) {
                if (numbers.get((index + index2) % 3).equals(pitchInput.get(index))) {
                    balls++;
                }
            }
        }

        return List.of(strikes, balls);
    }
}
