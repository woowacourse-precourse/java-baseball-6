package baseball;

import java.util.Map;

public class Comparator {

    private int ballCount;
    private int strikeCount;

    private void init() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public boolean compare(Map<Integer, Integer> generatedNumbers, Map<Integer, Integer> guessedNumbers) {
        init();

        countStrikeAndBall(generatedNumbers, guessedNumbers);

        StringBuilder result = new StringBuilder();
        if (ballCount != 0) result.append(ballCount).append("볼 ");
        if (strikeCount != 0) result.append(strikeCount).append("스트라이크");
        if (strikeCount == 0 && ballCount == 0) result.append("낫싱");

        System.out.println(result);

        return strikeCount == 3;
    }

    private void countStrikeAndBall(Map<Integer, Integer> generatedNumbers, Map<Integer, Integer> guessedNumbers) {
        for (int guessedNumber : guessedNumbers.keySet()) {
            if(!generatedNumbers.containsKey(guessedNumber)) {
                continue;
            }

            int generatedPosition = generatedNumbers.get(guessedNumber);
            int guessedPosition = guessedNumbers.get(guessedNumber);
            if (generatedPosition == guessedPosition) {
                strikeCount++;
                continue;
            }
            ballCount++;
        }
    }
}
