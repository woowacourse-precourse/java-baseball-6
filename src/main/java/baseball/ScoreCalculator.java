package baseball;

public class ScoreCalculator {
    public static Integer[] calculate(Integer[] pitchInput, Integer[] numbers) {
        Integer balls = 0;
        Integer strikes = 0;

        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index].equals(pitchInput[index])) {
                strikes++;
            }

            for (int index2 = 1; index2 < 3; index2++) {
                if (numbers[(index + index2) % 3].equals(pitchInput[index])) {
                    balls++;
                }
            }
        }

        return new Integer[]{strikes, balls};
    }
}
