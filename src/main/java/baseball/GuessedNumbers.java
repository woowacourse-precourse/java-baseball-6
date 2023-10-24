package baseball;

import java.util.List;

public class GuessedNumbers {

    private final List<Integer> numbers;

    public GuessedNumbers(List<Integer> numbers, BaseballGameRules gameRules) {
        validateNumbers(numbers, gameRules);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers, BaseballGameRules gameRules) {
        if (numbers.size() != gameRules.getNumberCount()) {
            throw new IllegalArgumentException("유저의 숫자의 개수가 게임 규칙과 일치하지 않습니다.");
        }

        for (int number : numbers) {
            if (number < gameRules.getMinNumber() || number > gameRules.getMaxNumber()) {
                throw new IllegalArgumentException("유저의 숫자에 하나 이상의 숫자가 허용된 범위를 벗어났습니다.");
            }
        }

        long uniqueNumberCount = numbers.stream().distinct().count();
        if (uniqueNumberCount != numbers.size()) {
            throw new IllegalArgumentException("유저의 숫자들 중 중복된 숫자가 있습니다.");
        }
    }
}
