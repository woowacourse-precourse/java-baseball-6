package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(final List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    private void validate() {
        validateLength();
        validateNoDuplicatedNumber();
    }

    private void validateLength() {
        if(numbers.size() != NumberConstants.NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoDuplicatedNumber() {
        numbers.forEach(number -> {
            if(numbers.indexOf(number) != numbers.lastIndexOf(number)) {
                throw new IllegalArgumentException();
            }
        });
    }

    public static Numbers ofString(final String input) {
        int dividend = Integer.parseInt(input);
        validateNotNegative(dividend);
        final List<Integer> numbers = new ArrayList<>();
        while(dividend > 0) {
            numbers.add(dividend % 10);
            dividend /= 10;
        }
        Collections.reverse(numbers);
        return new Numbers(numbers);
    }

    private static void validateNotNegative(final Integer integer) {
        if(integer < 0) {
            throw new IllegalArgumentException();
        }
    }

    public Judgement judge(final Numbers target) {
        return new Judgement(countStrike(target), countBall(target));
    }

    private int countStrike(final Numbers target) {
        int result = 0;
        for (int index = 0; index < numbers.size(); ++index) {
            if(target.judgeStrike(index, numbers.get(index))) {
                ++result;
            }
        }
        return result;
    }

    private int countBall(final Numbers target) {
        int result = 0;
        for (int index = 0; index < numbers.size(); ++index) {
            if(target.judgeBall(index, numbers.get(index))) {
                ++result;
            }
        }
        return result;
    }

    private boolean judgeStrike(int index, Integer number) {
        return numbers.get(index).equals(number);
    }

    private boolean judgeBall(int index, Integer number) {
        return numbers.contains(number) && index != numbers.indexOf(number);
    }
}
