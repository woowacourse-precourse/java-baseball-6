package baseball;

import java.util.Map;

public class Comparator {

    private int ballCount;
    private int strikeCount;
    private Map<Integer, Integer> generatedNumbers;
    private Map<Integer, Integer> guessedNumbers;

    private void init(Map<Integer, Integer> generatedNumbers, Map<Integer, Integer> guessedNumbers) {
        this.ballCount = 0;
        this.strikeCount = 0;
        this.generatedNumbers = generatedNumbers;
        this.guessedNumbers = guessedNumbers;
    }

    public boolean checkThreeStrikeAndPrintResult(Map<Integer, Integer> generatedNumbers, Map<Integer, Integer> guessedNumbers) {
        init(generatedNumbers, guessedNumbers);
        countStrikeAndBall();
        printResult();
        return strikeCount == 3;
    }

    private void printResult() {
        StringBuilder result = new StringBuilder();
        if (ballCount != 0) result.append(ballCount).append("볼 ");
        if (strikeCount != 0) result.append(strikeCount).append("스트라이크");
        if (strikeCount == 0 && ballCount == 0) result.append("낫싱");
        System.out.println(result);
    }

    private void countStrikeAndBall() {
        for (int guessedNumber : guessedNumbers.keySet()) {
            if(!generatedNumbers.containsKey(guessedNumber)) {
                continue;
            }
            countStrikeAndBall(guessedNumber);
        }
    }

    private void countStrikeAndBall(int guessedNumber) {
        int generatedPosition = generatedNumbers.get(guessedNumber);
        int guessedPosition = guessedNumbers.get(guessedNumber);
        if (generatedPosition == guessedPosition) {
            strikeCount++;
            return;
        }
        ballCount++;
    }
}
