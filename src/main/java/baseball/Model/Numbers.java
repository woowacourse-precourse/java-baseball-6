package baseball.Model;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    private static final int AMOUNT_OF_NUMBERS = 3;
    private final List<Number> values;

    public Numbers(List<Integer> numbers) {
        validateAmountOfNumbers(numbers.size());
        validateDuplicated(numbers.size(), numbers.stream().collect(Collectors.toSet()).size());
        values = initialize(numbers);
    }

    private List<Number> initialize(List<Integer> numbers) {
            return IntStream.range(0, numbers.size())
                    .mapToObj(index -> new Number(numbers.get(index), index))
                    .collect(Collectors.toList());
    }


    public List<Number> getValues() {
        return values;
    }

    private void validateAmountOfNumbers(int amountOfNumbers) {
        if (amountOfNumbers != AMOUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("숫자는 3개여야 합니다.");
        }
    }

    private void validateDuplicated(int numbers, int distinctNumbers) {
        if (numbers != distinctNumbers) {
            throw new IllegalArgumentException("숫자에 중복이 있습니다.");
        }
    }
}
