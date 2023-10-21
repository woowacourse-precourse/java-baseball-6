package baseball.model;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Computer {
    private static final int NUMBERS_SIZE = 3;

    private final List<Integer> numbers;

    public Computer(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumberRange(numbers);
        validateNumberDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers){
        if(numbers.size() != NUMBERS_SIZE){
            throw new IllegalArgumentException("숫자는 3개를 가져야 합니다");
        }
    }

    private void validateNumberRange(List<Integer> numbers){
        numbers.stream()
                .filter(number -> 1 > number || 9 < number)
                .findAny()
                .ifPresent(number ->
                { throw new IllegalArgumentException("숫자는 1부터 9까지의 수로 이루어져야 합니다");});
    }

    private void validateNumberDuplicate(List<Integer> numbers){
        long validNumberCount =  numbers.stream()
                .distinct()
                .count();
        if(validNumberCount != NUMBERS_SIZE){
            throw new IllegalArgumentException("숫자는 서로 다른 수로 이루어져 있어야 한다");
        }
    }
}
