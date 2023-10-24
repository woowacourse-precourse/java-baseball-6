package baseball.computer;

import baseball.BaseballGameRules;
import baseball.NumberBaseballGameResult;
import java.util.List;

public class NumberBaseballGameComputerPlayer {

    private List<Integer> numbers;

    public NumberBaseballGameComputerPlayer(List<Integer> numbers, BaseballGameRules gameRules) {
        validateNumbers(numbers, gameRules);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers, BaseballGameRules gameRules) {
        if (numbers.size() != gameRules.getNumberCount()) {
            throw new IllegalArgumentException("컴퓨터가 가지고 있는 숫자의 개수가 게임 규칙과 일치하지 않습니다.");
        }

        for (int number : numbers) {
            if (number < gameRules.getMinNumber() || number > gameRules.getMaxNumber()) {
                throw new IllegalArgumentException("컴퓨터의 숫자에 하나 이상의 숫자가 허용된 범위를 벗어났습니다.");
            }
        }

        long uniqueNumberCount = numbers.stream().distinct().count();
        if (uniqueNumberCount != numbers.size()) {
            throw new IllegalArgumentException("컴퓨터의 숫자들 중 중복된 숫자가 있습니다.");
        }
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
