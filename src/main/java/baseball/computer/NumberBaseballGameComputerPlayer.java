package baseball.computer;

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

    public NumberBaseballGameResult compareWith(List<Integer> otherNumbers) {
        if (otherNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("비교하려는 숫자의 개수가 컴퓨터의 숫자 개수와 일치하지 않습니다.");
        }

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
