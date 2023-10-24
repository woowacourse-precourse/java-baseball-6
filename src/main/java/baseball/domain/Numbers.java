package baseball.domain;

import baseball.controller.GameConstants;

import java.util.Arrays;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(final String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        List<Number> numbers = Arrays.stream(input.split(""))
                .map(n -> new Number(Integer.parseInt(n)))
                .toList();

        if (numbers.size() != GameConstants.NUMBER_SIZE.getNumber()) {
            throw new IllegalArgumentException("숫자는 3자리를 입력해야 합니다.");
        }

        if (numbers.stream().distinct().count() < GameConstants.NUMBER_SIZE.getNumber()) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야합니다.");
        }
        this.numbers = numbers;
    }

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public boolean hasNumber(Number target) {
        return numbers.stream().anyMatch(number -> number.equals(target));
    }

    public boolean checkSamePosition(int index, Number target) {
        return (hasNumber(target)) && numbers.get(index).equals(target);
    }

    public GameResult compareWith(final Numbers target) {
        GameResult gameResult = new GameResult();

        for (int i = 0; i < GameConstants.NUMBER_SIZE.getNumber(); i++) {
            if (target.checkSamePosition(i, numbers.get(i))) {
                gameResult.strike();
            } else if (target.hasNumber(numbers.get(i))) {
                gameResult.ball();
            }
        }
        return gameResult;
    }
}
