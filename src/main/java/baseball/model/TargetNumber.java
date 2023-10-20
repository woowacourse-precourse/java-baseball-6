package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TargetNumber {
    private final List<Number> numbers;

    private TargetNumber(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public static TargetNumber randomInstance(final int size) {
        List<Number> uniqueNumbers = new ArrayList<>();

        while (uniqueNumbers.size() < size) {
            Number randomNumber = Number.createRandomNumber();

            if (uniqueNumbers.contains(randomNumber)) {
                continue;
            }

            uniqueNumbers.add(randomNumber);
        }

        return new TargetNumber(Collections.unmodifiableList(uniqueNumbers));
    }
}
