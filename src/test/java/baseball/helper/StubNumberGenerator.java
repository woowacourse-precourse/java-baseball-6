package baseball.helper;

import baseball.model.Number;
import baseball.util.NumberGenerator;
import java.util.List;

public class StubNumberGenerator implements NumberGenerator {

    private final String numbers;

    public StubNumberGenerator(final String numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Number> generate() {
        return numbers.chars()
                .mapToObj(number -> new Number(Character.getNumericValue(number)))
                .toList();
    }
}
