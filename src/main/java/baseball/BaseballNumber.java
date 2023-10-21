package baseball;

import java.util.Collections;
import java.util.List;

public record BaseballNumber(List<Integer> numbers) {

    @Override
    public List<Integer> numbers() {
        return Collections.unmodifiableList(numbers);
    }
}
