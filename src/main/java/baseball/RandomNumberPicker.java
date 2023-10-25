package baseball;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberPicker {

    public List<Integer> pickDistinctNumbersInRange(int startNumber, int endNumber,
        int numberSize) {
        validateNumberRange(startNumber, endNumber);
        validateCanPickDistinctNumbers(startNumber, endNumber, numberSize);

        List<Integer> numbersInRange = getNumbersInRange(startNumber, endNumber);
        Collections.shuffle(numbersInRange);

        return numbersInRange.subList(0, numberSize);
    }

    private List<Integer> getNumbersInRange(int startNumber, int endNumber) {
        return IntStream.range(startNumber, endNumber)
            .boxed()
            .collect(Collectors.toList());
    }

    private void validateNumberRange(int startNumber, int endNumber) {
        if (startNumber >= endNumber) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCanPickDistinctNumbers(int startNumber, int endNumber, int numberSize) {
        if (endNumber - startNumber < numberSize) {
            throw new IllegalArgumentException();
        }
    }
}
