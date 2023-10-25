package baseball.domain;

import static baseball.utils.ErrorMessage.NUMBERS_NOT_POSITIVE_INTEGER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<Integer> numbers;

    public Player(String numberStr) {
        List<Integer> numbers = changeStringToPositiveIntegerList(numberStr);
        this.numbers = numbers;
    }

    public List<Integer> changeStringToPositiveIntegerList(String numberStr) throws IllegalArgumentException {
        try {
            List<Integer> numbers = Arrays.asList(numberStr.split(""))
                    .stream()
                    .map(Integer::parseUnsignedInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBERS_NOT_POSITIVE_INTEGER);
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
