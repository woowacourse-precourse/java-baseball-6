package baseball.numbers;

import baseball.BaseballGameRules;
import baseball.NumberBaseballGameResult;
import java.util.List;

public class NumberBaseballGameComputerPlayer {

    private final List<Integer> numbers;

    public NumberBaseballGameComputerPlayer(List<Integer> numbers, BaseballGameRules gameRules) {
        gameRules.validateNumbers(numbers);
        this.numbers = numbers;
    }

    public int getNumbersSize() {
        return numbers.size();
    }

    public NumberBaseballGameResult compareWith(GuessedNumbers guessedNumbers) {
        List<Integer> otherNumbers = guessedNumbers.getNumbers();

        int strikeCount = calculateStrikeCount(otherNumbers);
        int ballCount = calculateBallCount(otherNumbers);

        return new NumberBaseballGameResult(numbers.size(), strikeCount, ballCount);
    }

    private int calculateStrikeCount(List<Integer> otherNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(otherNumbers.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int calculateBallCount(List<Integer> otherNumbers) {
        int ballCount = 0;
        for (int i = 0; i < otherNumbers.size(); i++) {
            if (numbers.contains(otherNumbers.get(i)) && !numbers.get(i).equals(otherNumbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
