package baseball.domain;

import baseball.service.BaseballGame;
import baseball.utils.NumberUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Number> value;

    private Numbers(final List<Number> numbers) {
        this.value = numbers;
    }

    public List<Number> getValue() {
        return Collections.unmodifiableList(value);
    }

    public int containsCount(Numbers numbers) {
        int count = 0;
        List<Integer> thisList = value.stream()
                .map(number -> number.getValue())
                .collect(Collectors.toList());
        for (int i = 0; i < numbers.getValue().size(); i++) {
            if (i < thisList.size()) {
                if (thisList.contains(numbers.getValue().get(i).getValue()) && thisList.get(i) != numbers.getValue().get(i).getValue()) {
                    count++;
                }
            }
            if (i >= thisList.size()) {
                if (thisList.contains(numbers.getValue().get(i).getValue())) {
                    count++;
                }
            }
        }
        return count;
    }

    public int equalsCount(Numbers numbers) {
        int min = Math.min(numbers.value.size(), this.value.size());
        int count = 0;
        for (int i = 0; i < min; i++) {
            if (this.value.get(i).isEquals(numbers.value.get(i))) {
                count++;
            }
        }
        return count;
    }
    public static Numbers of(final List<Integer> numbers) {
        if (NumberUtil.validDuplicatedNumbers(numbers) && NumberUtil.validNumbersCount(numbers, BaseballGame.COMPUTER_NUMBER_SIZE)) {
            return new Numbers(numbers.stream()
                    .map(number -> Number.from(number))
                    .collect(Collectors.toList()));
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}
