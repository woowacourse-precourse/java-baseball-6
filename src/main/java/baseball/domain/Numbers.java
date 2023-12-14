package baseball.domain;

import baseball.global.exception.CustomException;
import baseball.global.exception.ErrorMessage;
import java.util.List;

public class Numbers {
    private static final int COUNT = 3;
    private List<Number> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = Validator.validate(numbers);
    }

    public int get(int index) {
        return numbers.get(index).getValue();
    }

    public int size() {
        return numbers.size();
    }

    private static class Validator {
        private static List<Number> validate(List<Integer> numbers) {
            validateLength(numbers);
            validateDuplicated(numbers);
            return numbers.stream()
                    .map(Number::new)
                    .toList();
        }

        private static void validateLength(List<Integer> numbers) {
            if (numbers.size() != COUNT) {
                throw CustomException.from(ErrorMessage.INVALID_NUMBER_ERROR);
            }
        }

        private static void validateDuplicated(List<Integer> items) {
            if (hasDuplicatedItem(items)) {
                throw CustomException.from(ErrorMessage.INVALID_NUMBER_ERROR);
            }
        }

        private static boolean hasDuplicatedItem(List<Integer> items) {
            return items.size() != calculateUniqueItemsCount(items);
        }

        private static int calculateUniqueItemsCount(List<Integer> items) {
            return (int) items.stream()
                    .distinct()
                    .count();
        }
    }
}
